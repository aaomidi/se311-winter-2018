package com.aaomidi.se311.homework.hw4.common.calc;

public interface Operation {
    Type getType();

    enum Type {
        OPERAND,
        OPERATOR
    }
}
