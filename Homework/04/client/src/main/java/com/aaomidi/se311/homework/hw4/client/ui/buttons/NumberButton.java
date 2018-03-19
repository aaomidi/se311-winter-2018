package com.aaomidi.se311.homework.hw4.client.ui.buttons;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorView;
import com.aaomidi.se311.homework.hw4.client.bean.operation.NumberOperation;

import java.awt.event.ActionEvent;

public class NumberButton extends CalculatorButton {
    private final int number;

    public NumberButton(CalculatorView parent, int number) {
        super(parent);
        this.number = number;
        setText(String.valueOf(number));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getController().apply(new NumberOperation(number));
        update();
    }
}
