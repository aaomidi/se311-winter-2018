package com.aaomidi.se311.homework.hw4.client.buttons;

import com.aaomidi.se311.homework.hw4.client.CalculatorView;
import com.aaomidi.se311.homework.hw4.client.ServiceRequest;
import com.aaomidi.se311.homework.hw4.common.calc.OpType;
import com.aaomidi.se311.homework.hw4.common.calc.Operator;

import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EqualsButton extends OperatorButton {

    public EqualsButton(CalculatorView parent) {
        super(parent, OpType.EQUALS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCalculator().addOperation(new Operator(opType));
        update();
        ServiceRequest serviceRequest = new ServiceRequest(parent.getCalculator());
        serviceRequest.run();
    }
}
