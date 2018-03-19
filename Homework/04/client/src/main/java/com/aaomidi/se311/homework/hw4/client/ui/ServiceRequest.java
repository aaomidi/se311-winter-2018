package com.aaomidi.se311.homework.hw4.client.ui;

import java.io.PrintStream;
import java.net.Socket;

public class ServiceRequest implements Runnable {
//    private final static Gson gson;
//
//    static {
//        gson = new GsonBuilder().registerTypeAdapter(Operation.class, new OperationSerializer()).create();
//    }

    private final String equation;

    public ServiceRequest(String equation) {
        this.equation = equation;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 41512)) {
            try (PrintStream ps = new PrintStream(socket.getOutputStream())) {
                ps.print(equation);
                socket.shutdownOutput();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
