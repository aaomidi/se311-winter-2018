package com.aaomidi.se311.homework.hw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServiceRequest implements Runnable {
    private final Socket client;

    public ServiceRequest(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStreamReader reader = new InputStreamReader(client.getInputStream())) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String equation = bufferedReader.readLine();
            System.out.println(equation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
