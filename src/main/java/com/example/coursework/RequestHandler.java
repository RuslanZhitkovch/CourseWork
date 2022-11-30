package com.example.coursework;

import com.example.coursework.ConnectionTCP;
import com.example.coursework.Command;
import com.example.coursework.User;
import com.example.coursework.UserRepository;
import com.example.coursework.UserRepositoryImpl;

import java.net.Socket;

import java.util.List;

public class RequestHandler implements Runnable {
    private final ConnectionTCP connectionTCP;
    public RequestHandler(Socket socket) {
        connectionTCP = new ConnectionTCP(socket);
    }

    @Override
    public void run() {

        UserRepository userRepository = new UserRepositoryImpl();

        while(true) {
            Command command = (Command) connectionTCP.readObject();
            switch (command) {
                case CREATE -> {
                    User user = (User) connectionTCP.readObject();
                    userRepository.add(user);
                }
                case UPDATE -> {
                    User user = (User) connectionTCP.readObject();
                    userRepository.update(user);
                }
                case READ -> {
                    List<User> user = userRepository.gelAll();
                    connectionTCP.writeObject(user);
                }
                case DELETE -> {
                    Integer id = (Integer) connectionTCP.readObject();
                    userRepository.deleteById(id);
                }

                case EXIT -> {
                    connectionTCP.close();
                    System.exit(0);
                }
            }
        }
    }
}
