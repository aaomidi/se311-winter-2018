package com.aaomidi.se311.homework.hw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServiceRequest implements Runnable {
//    private final static Gson gson;
//
//    static {
//        gson = new GsonBuilder().registerTypeAdapter(Operation.class, new OperationSerializer()).create();
//    }

    private final Socket client;

    public ServiceRequest(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStreamReader reader = new InputStreamReader(client.getInputStream())) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String equation = bufferedReader.readLine();
            //CalculatorPayload calculatorPayload = gson.fromJson(reader, CalculatorPayload.class);
            //System.out.println(calculatorPayload.getPayload().getMath());
            System.out.println(equation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
