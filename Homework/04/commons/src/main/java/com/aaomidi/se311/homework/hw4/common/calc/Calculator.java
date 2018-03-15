package com.aaomidi.se311.homework.hw4.common.calc;

import java.util.LinkedList;
import java.util.List;

public class Calculator implements Cloneable {
    private final List<Operation> operations = new LinkedList<>();

    // Helper Fields
    private transient CalculatorState state = CalculatorState.INIT;
    private transient CalculatorState previousState = CalculatorState.INIT;
    private transient StringBuilder sb;
    private transient Operator operator;
    private transient Operand result;
    private transient Operand val2;


    public synchronized void reset() {
        resetHelper();
        operations.clear();
    }

    private synchronized void resetHelper() {
        sb = new StringBuilder();
        operator = null;
        result = null;
        val2 = Operand.zeroOperand();
        previousState = CalculatorState.INIT;
        state = CalculatorState.INIT;
    }

    public synchronized void addOperation(Operation operation) {
        operations.add(operation);
    }

    private synchronized void setState(CalculatorState state) {
        this.previousState = this.state;
        this.state = state;
    }

    public synchronized void handleDiscard() {
        operations.remove(operations.size() - 1);
    }

    public synchronized String getDisplay() {
        calculate();
        switch (state) {
            case INIT:
                return "0";
            case DIGIT:
                return String.valueOf(val2.getValue());

            case FINISH:
            case NON_DIGIT:
                return String.valueOf(result.getValue());
            default:
            case ERROR:
                return "ERR";

        }
    }

    public synchronized String getMath() {
        int res = calculate();
        if (state == CalculatorState.FINISH) {
            sb.append(res);
        }
        return sb.toString();
    }

    public synchronized Integer calculate() {
        resetHelper();
        try {
            for (Operation operation : operations) {
                handleOperation(operation);
                sb.append(operation);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        Integer res;
        if (result == null) {
            res = val2.getValue();
        } else {
            res = result.getValue();
        }
        return res;
    }

    private synchronized void handleOperation(Operation operation) {
        switch (operation.getType()) {
            case OPERAND:
                handleOperand((Operand) operation);
                break;
            case OPERATOR:
                handleOperator((Operator) operation);
                break;
        }
    }

    private synchronized void handleOperand(Operand operand) {
        switch (state) {
            case ERROR:
                return;
            case FINISH:
                reset();
                operations.add(operand);
                break;
        }
        val2 = val2.append(operand);
        setState(CalculatorState.DIGIT);
    }

    private synchronized void handleOperator(Operator operator) {
        try {
            switch (state) {
                case INIT:
                    return;
                case DIGIT: {
                    if (this.operator == null) {
                        result = val2;
                    } else {
                        result = this.operator.apply(result, val2);
                    }
                    val2 = Operand.zeroOperand();

                    this.operator = operator;
                    if (operator.isEnd()) {
                        setState(CalculatorState.FINISH);
                    } else {
                        setState(CalculatorState.NON_DIGIT);
                    }
                    break;
                }
                case NON_DIGIT:
                    setState(CalculatorState.ERROR);
                    break;
                case ERROR:
                    return;
                case FINISH:
                    reset();
                    break;
            }
        } catch (Exception ex) {
            setState(CalculatorState.ERROR);
        }

    }

}
