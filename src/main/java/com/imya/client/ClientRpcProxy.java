package com.imya.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

/**
 * rpc 客户端远程代理
 * Created by LL on 2018/5/31 0031.
 */
public class ClientRpcProxy {

    // 内部动态代理类
    private static class ProxyClient implements InvocationHandler {

        private final Class<?> serviceInterface;

        private final InetSocketAddress inetSocketAddress;

        public ProxyClient(Class<?> serviceInterface, InetSocketAddress inetSocketAddress) {
            this.serviceInterface = serviceInterface;
            this.inetSocketAddress = inetSocketAddress;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}
