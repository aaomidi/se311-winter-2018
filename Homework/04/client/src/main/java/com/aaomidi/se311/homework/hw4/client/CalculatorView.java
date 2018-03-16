package com.aaomidi.se311.homework.hw4.client;

import com.aaomidi.se311.homework.hw4.client.buttons.*;
import com.aaomidi.se311.homework.hw4.common.calc.operation.OpType;

import javax.swing.*;
import java.awt.*;

public class CalculatorView {
    private final CalculatorController controller;

    private JFrame guiFrame;

    private JPanel panel;
    private JPanel actionPanel;
    private JPanel numberPanel;
    private JPanel resultPanel;
    private JPanel operatorPanel;
    private CalculatorDisplay display;

    public CalculatorView() {
        this.controller = new CalculatorController();
        display = new CalculatorDisplay(controller);
        initialize();
    }

    private void initialize() {
        guiFrame = new JFrame("Calculator");
        guiFrame.setPreferredSize(new Dimension(300, 300));

        panel = new JPanel();
        actionPanel = new JPanel();
        numberPanel = new JPanel();
        resultPanel = new JPanel();
        operatorPanel = new JPanel();

        display = new CalculatorDisplay(controller);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.X_AXIS));
        numberPanel.setLayout(new GridLayout(4, 3));
        operatorPanel.setLayout(new GridLayout(5, 1));

        prepareNumberPanel(numberPanel);
        prepareOperatorPanel(operatorPanel);
        prepareExtras(numberPanel);

        // Make Calculator use this main panel
        guiFrame.getContentPane().add(panel);

        panel.add(display);
        panel.add(resultPanel);
        panel.add(actionPanel);
        actionPanel.add(numberPanel);
        actionPanel.add(operatorPanel);

        guiFrame.pack();
        guiFrame.setVisible(true);
        update();
    }

    private void prepareExtras(JPanel numberPanel) {
        numberPanel.add(new NumberButton(this, 0));
        numberPanel.add(new DiscardButton(this));
        numberPanel.add(new ResetButton(this));
    }

    private void prepareNumberPanel(JPanel panel) {
        panel.setPreferredSize(new Dimension(250, 250));
        for (int i = 1; i <= 9; i++) {
            panel.add(new NumberButton(this, i));
        }
    }

    private void prepareOperatorPanel(JPanel panel) {

        for (OpType ot : OpType.values()) {
            panel.add(new OperatorButton(this, ot));
        }
        panel.add(new EqualsButton(this));
    }

    public CalculatorController getController() {
        return controller;
    }

    public void update() {
        this.display.update();
    }
}
