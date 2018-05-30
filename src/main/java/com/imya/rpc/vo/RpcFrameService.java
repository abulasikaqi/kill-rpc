package com.imya.rpc.vo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LL on 2018/5/31 0031.
 */
public class RpcFrameService {
    // 服务注册中心
    private static final ConcurrentHashMap<String, Class<?>> serviceHandler = new ConcurrentHashMap<>();

    // 服务的执行器
    private static ExecutorService executorService = Executors.newFixedThreadPool(8);

    private int port;

    public RpcFrameService(int port) {
        this.port = port;
    }

    // 服务的注册
    public void registerService(Class serviceInterface, Class impl) {
        serviceHandler.put(serviceInterface.getName(), impl);
    }

    // 处理服务请求的任务
    private static class ServerTask implements Runnable {

        private Socket client;

        public ServerTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
                 ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream())) {

                String serviceName = inputStream.readUTF(); // 服务名
                String methodName = inputStream.readUTF(); // 服务方法名
                Class<?>[] paramTypes = (Class<?>[]) inputStream.readObject(); // 方法的参数类型
                Object[] args = (Object[]) inputStream.readObject(); // 方法的参数

                Class<?> clazz = serviceHandler.get(serviceName);
                Method method = clazz.getMethod(methodName, paramTypes);
                Object result = method.invoke(clazz.newInstance(), args);

                outputStream.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 启动服务
    public void start() throws IOException {

        System.out.println("Server is start on " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                executorService.execute(new ServerTask(serverSocket.accept()));
            }
        }
    }
}
