package com.aaomidi.se311.homework.hw4.client.ui.buttons;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorController;
import com.aaomidi.se311.homework.hw4.client.ui.CalculatorView;

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
