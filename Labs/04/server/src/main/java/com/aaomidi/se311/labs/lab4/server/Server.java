package com.aaomidi.se311.labs.lab4.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ExecutorService service = Executors.newFixedThreadPool(10);

    public Server(String... args) {
        try (ServerSocket socket = new ServerSocket(45321)) {
            while (true) {
                System.out.println("Waiting...");
                Socket client = socket.accept();
                System.out.println("Connection acquired.");
                service.submit(new ServiceRequest(client));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        new Server(args);
    }

}
