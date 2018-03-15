package com.aaomidi.se311.homework.hw4.client.buttons;

import com.aaomidi.se311.homework.hw4.common.calc.Calculator;

import javax.swing.*;

public class CalculatorDisplay extends JTextField {
    private final Calculator calculator;

    public CalculatorDisplay(Calculator calculator) {
        this.calculator = calculator;
    }

    public void update() {
        this.setText(calculator.getDisplay());
    }
}
