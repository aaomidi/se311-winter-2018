package com.aaomidi.se311.homework.hw4.client.ui.buttons;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorView;

import java.awt.event.ActionEvent;

public class ResetButton extends CalculatorButton {

    public ResetButton(CalculatorView parent) {
        super(parent);
        setText("C");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getController().reset();
        update();
    }
}
