package com.aaomidi.se311.homework.hw4.client.bean.calculator;

import com.aaomidi.se311.homework.hw4.client.bean.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.client.bean.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.client.bean.operation.OpType;
import com.aaomidi.se311.homework.hw4.client.bean.operation.OperatorOperation;

public class ErrorCalculator extends Calculator {
    protected ErrorCalculator(Calculator previous, int finalValue, int currentValue, OpType opType) {
        super(previous, finalValue, currentValue, opType);
    }

    @Override
    public Calculator apply(NumberOperation operation) {
        return this;
    }

    @Override
    public Calculator apply(OperatorOperation operation) {
        return this;
    }

    @Override
    public Calculator apply(EqualsOperation operation) {
        // Handle it the same as any other OperatorOperation
        return apply((OperatorOperation) operation);
    }

    @Override
    public String getDisplay() {
        return "ERR";
    }

    @Override
    public String getEquationRepresentation() {
        return "";
    }
}
