package com.aaomidi.se311.homework.hw4.client.ui;

import com.aaomidi.se311.homework.hw4.client.bean.calculator.Calculator;
import com.aaomidi.se311.homework.hw4.client.bean.calculator.InitCalculator;
import com.aaomidi.se311.homework.hw4.client.bean.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.client.bean.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.client.bean.operation.OperatorOperation;

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
