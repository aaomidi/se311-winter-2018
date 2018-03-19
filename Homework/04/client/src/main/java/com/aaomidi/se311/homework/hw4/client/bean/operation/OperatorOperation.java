package com.aaomidi.se311.homework.hw4.client.bean.operation;

import com.aaomidi.se311.homework.hw4.client.bean.Operation;
import com.aaomidi.se311.homework.hw4.client.bean.calculator.Calculator;

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
