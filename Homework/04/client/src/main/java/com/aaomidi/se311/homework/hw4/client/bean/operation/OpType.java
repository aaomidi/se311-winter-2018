package com.aaomidi.se311.homework.hw4.client.bean.operation;

import java.util.function.BiFunction;

public enum OpType {
    ADD("+", (operand, operand2) -> operand + operand2),
    SUBTRACT("-", (operand, operand2) -> operand - operand2),
    MULTIPLY("*", (operand, operand2) -> operand * operand2),
    DIVIDE("/", (operand, operand2) -> operand / operand2);
    final String op;
    final BiFunction<Integer, Integer, Integer> function;

    OpType(String op, BiFunction<Integer, Integer, Integer> function) {
        this.op = op;
        this.function = function;
    }

    public String getOp() {
        return op;
    }

    public int apply(int a, int b) {
        return function.apply(a, b);
    }
}
