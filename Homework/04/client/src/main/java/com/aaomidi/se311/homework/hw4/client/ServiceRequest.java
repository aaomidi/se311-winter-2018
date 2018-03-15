package com.aaomidi.se311.homework.hw4.client;

import com.aaomidi.se311.homework.hw4.common.calc.Calculator;

import java.io.PrintStream;
import java.net.Socket;

public class ServiceRequest implements Runnable {
//    private final static Gson gson;
//
//    static {
//        gson = new GsonBuilder().registerTypeAdapter(Operation.class, new OperationSerializer()).create();
//    }

    private final Calculator calculator;

    public ServiceRequest(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 41512)) {
            String send = calculator.getMath();
            try (PrintStream ps = new PrintStream(socket.getOutputStream())) {
                ps.print(send);
                socket.shutdownOutput();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
