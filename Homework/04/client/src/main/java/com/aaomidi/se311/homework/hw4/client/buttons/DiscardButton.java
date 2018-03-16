package com.aaomidi.se311.homework.hw4.client.buttons;

import com.aaomidi.se311.homework.hw4.client.CalculatorView;

import java.awt.event.ActionEvent;

public class DiscardButton extends CalculatorButton {
    public DiscardButton(CalculatorView parent) {
        super(parent);
        setText("Discard");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.getController().discard();
        update();
    }
}
