package com.aaomidi.se311.homework.hw4.common.calc;

import java.util.function.BiFunction;

public enum OpType {
    ADD("+", (operand, operand2) -> new Operand(operand.getValue() + operand2.getValue())),
    SUBTRACT("-", (operand, operand2) -> new Operand(operand.getValue() - operand2.getValue())),
    MULTIPLY("*", (operand, operand2) -> new Operand(operand.getValue() * operand2.getValue())),
    DIVIDE("/", (operand, operand2) -> new Operand(operand.getValue() / operand2.getValue())),
    EQUALS("=", (operand, operand2) -> new Operand(operand.getValue()));
    final String op;
    final BiFunction<Operand, Operand, Operand> function;

    OpType(String op, BiFunction<Operand, Operand, Operand> function) {
        this.op = op;
        this.function = function;
    }

    public String getOp() {
        return op;
    }
}
