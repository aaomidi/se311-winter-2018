package com.aaomidi.se311.labs.lab4.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    private final ExecutorService service = Executors.newFixedThreadPool(10);

    public Client(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your list of numbers. After each number press enter. Entering anything other than a number will make the program assume you're done entering numbers.");
        List<Integer> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            try {
                Integer val = Integer.valueOf(input);
                list.add(val);
            } catch (Exception ex) {
                System.out.println("You're done entering numbers.");
                break;
            }
        }

        service.submit(new ServiceRequest(list));
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        new Client(args);
    }
}
