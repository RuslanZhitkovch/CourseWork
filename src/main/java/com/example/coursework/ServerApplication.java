package com.example.coursework;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection established\nIP:" + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                new Thread(new RequestHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
