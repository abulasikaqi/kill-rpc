package com.imya.prepare.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * client
 * Created by LL on 2018/5/30 0030.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;

        ObjectOutputStream outputStream = null;

        ObjectInputStream inputStream = null;

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 10001);

        try {
            socket = new Socket();
            socket.connect(inetSocketAddress);

            outputStream = new ObjectOutputStream(socket.getOutputStream());

            inputStream = new ObjectInputStream(socket.getInputStream());

        }finally {
            if (socket != null) socket.close();
            if (outputStream != null ) outputStream.close();
            if (inputStream != null ) inputStream.close();
        }
    }
}
