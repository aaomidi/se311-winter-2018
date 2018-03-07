package com.aaomidi.se311.labs.lab4.server;

import com.aaomidi.se311.labs.lab4.commons.api.Payload;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServiceRequest implements Runnable {
    private final Gson gson = new Gson();
    private final Socket client;

    public ServiceRequest(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStreamReader reader = new InputStreamReader(client.getInputStream())) {
            Payload payload = gson.fromJson(reader, Payload.class);
            Payload result = OddFinder.filterOdds(payload);
            String json = gson.toJson(result, Payload.class);

            PrintStream ps = new PrintStream(client.getOutputStream());
            ps.println(json);
            client.shutdownOutput();

        } catch (Exception ignored) {
        } finally {
            try {
                client.close();
            } catch (IOException ignored) {
            }
        }
    }
}
