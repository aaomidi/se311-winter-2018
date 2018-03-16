package com.aaomidi.se311.homework.hw4.common.calc.operation;

import com.aaomidi.se311.homework.hw4.common.calc.Operation;
import com.aaomidi.se311.homework.hw4.common.calc.calculator.Calculator;

public class ClearOperation implements Operation {
    @Override
    public Calculator apply(Calculator calculator) {
        return calculator.reset();
    }
}
