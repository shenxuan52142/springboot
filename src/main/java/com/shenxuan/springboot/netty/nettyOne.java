package com.shenxuan.springboot.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class nettyOne {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket clientSocket = serverSocket.accept();
    }
}
