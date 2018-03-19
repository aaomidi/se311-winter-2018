package com.aaomidi.se311.homework.hw4.client.bean.operation;

import com.aaomidi.se311.homework.hw4.client.bean.Operation;
import com.aaomidi.se311.homework.hw4.client.bean.calculator.Calculator;

public class DiscardOperation implements Operation {
    @Override
    public Calculator apply(Calculator calculator) {
        return calculator.discard();
    }
}
