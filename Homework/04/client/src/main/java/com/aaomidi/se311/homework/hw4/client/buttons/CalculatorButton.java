package com.aaomidi.se311.homework.hw4.client.buttons;

import com.aaomidi.se311.homework.hw4.client.CalculatorController;
import com.aaomidi.se311.homework.hw4.client.CalculatorView;
import com.aaomidi.se311.homework.hw4.common.calc.calculator.Calculator;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class CalculatorButton extends JButton implements ActionListener {
    protected final CalculatorView parent;

    public CalculatorButton(CalculatorView parent) {
        this.parent = parent;
        addActionListener(this);
    }

     CalculatorController getController() {
        return parent.getController();
    }

    void update() {
        parent.update();
    }
}