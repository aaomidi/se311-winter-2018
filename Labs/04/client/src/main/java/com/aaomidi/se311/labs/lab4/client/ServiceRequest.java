package com.aaomidi.se311.labs.lab4.client;

import com.aaomidi.se311.labs.lab4.commons.api.Payload;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

public class ServiceRequest implements Runnable {
    private final Gson gson = new Gson();
    private final List<Integer> list;

    public ServiceRequest(List<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 45321)) {
            Payload payload = new Payload(list);

            try (PrintStream ps = new PrintStream(socket.getOutputStream())) {
                ps.print(gson.toJson(payload));
                socket.shutdownOutput();
                Payload result = gson.fromJson(new InputStreamReader(socket.getInputStream()), Payload.class);
                if (result == null || result.getList() == null) return;

                result.getList().forEach(i -> System.out.println(i + ", "));
            }

        } catch (Exception ignored) {
            System.out.println("Something went wrong.");
        }
    }

}
