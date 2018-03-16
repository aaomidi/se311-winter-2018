package com.aaomidi.se311.homework.hw4.common.calc.calculator;

import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public class FinishCalculator extends Calculator {
    protected FinishCalculator(Calculator previous, int finalValue) {
        super(previous, finalValue, 0, null);
    }

    @Override
    public Calculator apply(NumberOperation operation) {
        return new FirstNumberCalculator(new InitCalculator(), operation.getNumber());
    }

    @Override
    public Calculator apply(OperatorOperation operation) {
        return new InitCalculator();
    }

    @Override
    public Calculator apply(EqualsOperation operation) {
        return apply((OperatorOperation) operation);
    }

    @Override
    public String getEquationRepresentation() {
        return "=" + finalValue;
    }

    @Override
    public String getDisplay() {
        return String.valueOf(finalValue);
    }
}
