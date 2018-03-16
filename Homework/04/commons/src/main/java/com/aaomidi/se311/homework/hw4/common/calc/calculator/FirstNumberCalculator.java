package com.aaomidi.se311.homework.hw4.common.calc.calculator;

import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public class FirstNumberCalculator extends Calculator {
    protected FirstNumberCalculator(Calculator previous, int currentValue) {
        super(previous, 0, currentValue, null);
    }

    @Override
    public Calculator apply(NumberOperation operation) {
        return new FirstNumberCalculator(this, this.currentValue * 10 + operation.getNumber());
    }

    @Override
    public Calculator apply(OperatorOperation operation) {
        return new OperatorCalculator(this, currentValue, operation.getOpType());
    }

    @Override
    public Calculator apply(EqualsOperation operation) {
        return new ErrorCalculator(this, finalValue, currentValue, opType);
    }

    @Override
    public String getEquationRepresentation() {
        return String.valueOf(currentValue);
    }
}
