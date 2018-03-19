package com.aaomidi.se311.homework.hw4.client.bean;

import com.aaomidi.se311.homework.hw4.client.bean.calculator.Calculator;

public interface Operation {
    default Calculator apply(Calculator calculator) {
        return calculator.apply(this);
    }

}
