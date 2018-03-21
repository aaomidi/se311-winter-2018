package com.aaomidi.se311.homework.hw4.client;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorView;

public class Client {
    private final CalculatorView calc;

    public Client() {
        this.calc = new CalculatorView();
    }

    public static void main(String... args) {
        new Client();
    }
}

