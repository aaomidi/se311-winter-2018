package com.aaomidi.se311.homework.hw4.common.calc.operation;

import com.aaomidi.se311.homework.hw4.common.calc.Operation;

public class NumberOperation implements Operation {
    public int getNumber() {
        return number;
    }

    private final int number;

    public NumberOperation(int number) {
        this.number = number;
    }

}
