package com.example.coursework;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);
                System.out.println("Сервер успешно запустился.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Установленно новое соединение\nIP:" + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                new Thread(new RequestHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
