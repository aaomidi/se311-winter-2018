package com.aaomidi.se311.homework.hw4.common.calc;

import com.aaomidi.se311.homework.hw4.common.calc.calculator.Calculator;
import com.aaomidi.se311.homework.hw4.common.calc.calculator.InitCalculator;
import com.aaomidi.se311.homework.hw4.common.calc.operation.EqualsOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.NumberOperation;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OpType;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

public class CommonMain {
    public static void main(String... args) {
        Calculator calculator = new InitCalculator();
        calculator = calculator.apply(new NumberOperation(3));
        calculator = calculator.apply(new NumberOperation(3));
        calculator = calculator.apply(new OperatorOperation(OpType.ADD));
        calculator = calculator.apply(new NumberOperation(3));
        calculator = calculator.apply(new NumberOperation(3));
        calculator = calculator.apply(new OperatorOperation(OpType.ADD));
        calculator = calculator.apply(new NumberOperation(3));
        calculator = calculator.apply(new NumberOperation(3));
        calculator = calculator.apply(new EqualsOperation());

        System.out.println(calculator.getFinalValue());
    }
}
