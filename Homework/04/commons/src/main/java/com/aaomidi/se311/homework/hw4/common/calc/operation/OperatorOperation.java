package com.aaomidi.se311.homework.hw4.common.calc.operation;

import com.aaomidi.se311.homework.hw4.common.calc.Operation;
import com.aaomidi.se311.homework.hw4.common.calc.calculator.Calculator;

public class OperatorOperation implements Operation {
    private final OpType opType;

    public OperatorOperation(OpType opType) {
        this.opType = opType;
    }

    public OpType getOpType() {
        return opType;
    }

    @Override
    public Calculator apply(Calculator calculator) {
        return calculator.apply(this);
    }
}
