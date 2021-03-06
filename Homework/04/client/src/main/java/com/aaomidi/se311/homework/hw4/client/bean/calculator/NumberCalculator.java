package com.aaomidi.se311.homework.hw4.client.bean.calculator;

import com.aaomidi.se311.homework.hw4.client.bean.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.client.bean.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.client.bean.operation.OpType;
import com.aaomidi.se311.homework.hw4.client.bean.operation.OperatorOperation;

public class NumberCalculator extends Calculator {
    NumberCalculator(Calculator previous, int finalValue, int currentValue, OpType operation) {
        super(previous, finalValue, currentValue, operation);
    }

    @Override
    public Calculator apply(NumberOperation operation) {
        return new NumberCalculator(this,
                finalValue,
                (this.currentValue * 10 + operation.getNumber()),
                opType);
    }

    @Override
    public Calculator apply(OperatorOperation operation) {
        return new OperatorCalculator(this, opType.apply(finalValue, currentValue), operation.getOpType());
    }

    @Override
    public Calculator apply(EqualsOperation operation) {
        return new FinishCalculator(this, opType.apply(finalValue, currentValue));
    }

    @Override
    public String getEquationRepresentation() {
        return String.valueOf(currentValue) ;
    }
}
