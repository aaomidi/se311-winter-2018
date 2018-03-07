package com.aaomidi.se311.labs.lab4.client;

import com.aaomidi.se311.labs.lab4.commons.Payload;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ServiceRequest implements Runnable {
    private final Gson gson = new Gson();

    public static ArrayList<Integer> randomListMaker() {
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomList.add(ThreadLocalRandom.current().nextInt(0, 100));
        }
        return randomList;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 45321)) {
            Payload payload = new Payload(randomListMaker());

            try (PrintStream ps = new PrintStream(socket.getOutputStream())) {
                ps.print(gson.toJson(payload));
                socket.shutdownOutput();
                Payload result = gson.fromJson(new InputStreamReader(socket.getInputStream()), Payload.class);
                System.out.println(result);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
