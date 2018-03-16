package com.aaomidi.se311.homework.hw4.client.buttons;

import com.aaomidi.se311.homework.hw4.client.CalculatorView;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OpType;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OperatorOperation;

import java.awt.event.ActionEvent;

public class OperatorButton extends CalculatorButton {
    protected final OpType opType;

    public OperatorButton(CalculatorView parent, OpType opType) {
        super(parent);
        this.opType = opType;
        setText(opType.getOp());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        getController().apply(new OperatorOperation(opType));
        update();
    }
}
