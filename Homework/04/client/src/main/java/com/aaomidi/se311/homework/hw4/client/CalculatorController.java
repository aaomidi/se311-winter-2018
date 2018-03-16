package com.aaomidi.se311.homework.hw4.client;

import com.aaomidi.se311.homework.hw4.common.calc.calculator.Calculator;
import com.aaomidi.se311.homework.hw4.common.calc.calculator.InitCalculator;
import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public class CalculatorController {
    private Calculator currentState = new InitCalculator();


    public void apply(EqualsOperation operation) {
        currentState = currentState.apply(operation);
    }

    public void apply(NumberOperation operation) {
        currentState = currentState.apply(operation);
    }

    public void apply(OperatorOperation operation) {
        currentState = currentState.apply(operation);
    }

    public String getDisplay() {
        return currentState.getDisplay();
    }

    public void reset() {
        currentState = currentState.reset();
    }

    public void discard() {
        currentState = currentState.discard();
    }

    public String getEquation() {
        return currentState.getEquation();
    }
}
