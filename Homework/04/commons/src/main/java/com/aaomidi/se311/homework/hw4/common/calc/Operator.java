package com.aaomidi.se311.homework.hw4.common.calc;

public class Operator implements Operation {
    private final OpType opType;

    public Operator(OpType opType) {
        this.opType = opType;
    }

    @Override
    public Type getType() {
        return Type.OPERATOR;
    }

    public Operand apply(Operand op1, Operand op2) {
        return opType.function.apply(op1, op2);
    }

    public boolean isEnd() {
        return opType == OpType.EQUALS;
    }

    @Override
    public String toString() {
        return opType.op;
    }

}
