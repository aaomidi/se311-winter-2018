package com.aaomidi.se311.homework.hw4.common.calc;

public class Operand implements Operation {
    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public static Operand zeroOperand() {
        return new Operand(0);
    }

    public int getValue() {
        return value;
    }

    public Operand append(Operand operand) {
        //return new Operand((Math.pow(10, Math.floor(Math.log10(operand.value)) + 1) * this.value + operand.value));
        return new Operand(10 * this.value + operand.getValue());
    }

    @Override
    public Type getType() {
        return Type.OPERAND;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
