package com.aaomidi.se311.homework.hw4.common.calc.calculator;

import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OpType;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public class OperatorCalculator extends Calculator {
    OperatorCalculator(Calculator previous, int finalValue, OpType opType) {
        super(previous, finalValue, 0, opType);
    }

    @Override
    public Calculator apply(NumberOperation operation) {
        return new NumberCalculator(this, finalValue, operation.getNumber(), opType);
    }

    @Override
    public Calculator apply(OperatorOperation operation) {
        return new ErrorCalculator(this, finalValue, currentValue, opType);
    }

    @Override
    public Calculator apply(EqualsOperation operation) {
        return apply((OperatorOperation) operation);
    }

    @Override
    public String getDisplay() {
        return String.valueOf(finalValue);
    }

    @Override
    public String getEquationRepresentation() {
        return opType.getOp();
    }
}
