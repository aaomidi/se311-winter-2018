package com.aaomidi.se311.homework.hw4.common.calc;

import com.aaomidi.se311.homework.hw4.common.calc.calculator.Calculator;

public interface Operation {
    default Calculator apply(Calculator calculator) {
        return calculator.apply(this);
    }

}
