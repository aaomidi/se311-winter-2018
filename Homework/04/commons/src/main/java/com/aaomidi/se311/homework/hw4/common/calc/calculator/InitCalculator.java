package com.aaomidi.se311.homework.hw4.common.calc.calculator;

import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public class InitCalculator extends Calculator {

    public InitCalculator() {
        super(null, 0, 0, null);
    }

    @Override
    public Calculator apply(NumberOperation operation) {
        return new FirstNumberCalculator(this, operation.getNumber());
    }

    @Override
    public Calculator apply(OperatorOperation operation) {
        return this;
    }

    @Override
    public Calculator apply(EqualsOperation operation) {
        return this;
    }

    @Override
    public String getEquationRepresentation() {
        return "";
    }
}
