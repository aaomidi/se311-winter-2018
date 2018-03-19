package com.aaomidi.se311.homework.hw4.client.ui.buttons;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorController;

import javax.swing.*;

public class CalculatorDisplay extends JTextField {
    private final CalculatorController controller;

    public CalculatorDisplay(CalculatorController controller) {
        this.controller = controller;
    }

    public void update() {
        this.setText(controller.getDisplay());
    }
}
