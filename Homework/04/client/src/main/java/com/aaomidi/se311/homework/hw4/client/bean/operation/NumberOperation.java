package com.aaomidi.se311.homework.hw4.client.bean.operation;

import com.aaomidi.se311.homework.hw4.client.bean.Operation;

public class NumberOperation implements Operation {
    public int getNumber() {
        return number;
    }

    private final int number;

    public NumberOperation(int number) {
        this.number = number;
    }

}
