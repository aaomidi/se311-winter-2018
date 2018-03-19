package com.aaomidi.se311.homework.hw4.client;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorView;

public class Main {
    private final CalculatorView calc;

    public Main() {
        this.calc = new CalculatorView();
    }

    public static void main(String... args) {
        new Main();
    }
}
