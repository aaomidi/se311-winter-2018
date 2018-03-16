package com.aaomidi.se311.homework.hw4.common.calc.calculator;


import com.aaomidi.se311.homework.hw4.common.calc.Operation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OpType;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public abstract class Calculator {
    private static final int MAX_LOOP = 1000;
    final int finalValue;
    final int currentValue;
    final OpType opType;
    private final Calculator previous;

    protected Calculator(Calculator previous, int finalValue, int currentValue, OpType opType) {
        this.previous = previous;
        this.finalValue = finalValue;
        this.currentValue = currentValue;
        this.opType = opType;
    }


    public Calculator apply(Operation operation) {
        // Shouldn't be called
        throw new RuntimeException("Shouldn't be called!");
    }

    public abstract Calculator apply(NumberOperation operation);

    public abstract Calculator apply(OperatorOperation operation);

    public abstract Calculator apply(EqualsOperation operation);

    public Calculator reset() {
        return new InitCalculator();
    }

    public Calculator discard() {
        if (previous == null) {
            return reset();
        }
        return previous;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "previous=" + previous +
                ", finalValue=" + finalValue +
                ", currentValue=" + currentValue +
                ", opType=" + opType +
                '}';
    }

    public String getDisplay() {
        return String.valueOf(currentValue);
    }

    public int getFinalValue() {
        return finalValue;
    }

    Calculator getPreviousCalculatorDifferentType() {
        Calculator calc = this;
        Class clazz = this.getClass();

        while (true) {
            if (calc.previous == null) return null;

            calc = calc.previous;
            if (calc.getClass().equals(clazz)) continue;

            return calc;
        }

    }

    public abstract String getEquationRepresentation();

    public String getEquation() {
        StringBuilder sb = new StringBuilder();
        Calculator calculator = this;
        int i = 0;
        while (true) {
            sb.insert(0, calculator.getEquationRepresentation());
            calculator = calculator.getPreviousCalculatorDifferentType();
            if (calculator == null || i++ >= MAX_LOOP) {
                break;
            }
        }
        return sb.toString();
    }
}
