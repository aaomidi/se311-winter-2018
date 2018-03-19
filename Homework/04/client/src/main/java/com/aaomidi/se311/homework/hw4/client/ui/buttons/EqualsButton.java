package com.aaomidi.se311.homework.hw4.client.ui.buttons;

import com.aaomidi.se311.homework.hw4.client.ui.CalculatorView;
import com.aaomidi.se311.homework.hw4.client.ui.ServiceRequest;
import com.aaomidi.se311.homework.hw4.client.bean.operation.EqualsOperation;

import java.awt.event.ActionEvent;

public class EqualsButton extends CalculatorButton {

    public EqualsButton(CalculatorView parent) {
        super(parent);
        setText("=");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getController().apply(new EqualsOperation());
        update();
        System.out.println(parent.getController().getEquation());
        ServiceRequest serviceRequest = new ServiceRequest(parent.getController().getEquation());
        serviceRequest.run();
    }
}
