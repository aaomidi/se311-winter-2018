package com.aaomidi.se311.labs.lab4.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private final ExecutorService service = Executors.newFixedThreadPool(10);

    public Client(String... args) {
        Runnable runnable = () -> service.submit(new ServiceRequest());
        for (int i = 0; i < 10; i++) {
            service.submit(runnable);
        }
        //service.shutdown();
    }

    public static void main(String... args) {
        new Client(args);
    }
}
