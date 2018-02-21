package com.aaomidi.se311.homework.hw3.bean.io.actions;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.Line;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;
import com.aaomidi.se311.homework.hw3.bean.io.Action;

import java.util.HashSet;
import java.util.Scanner;

public class AddAction extends Action {
    private final static HashSet<String> listenTo;

    static {
        listenTo = new HashSet<>();
        listenTo.add("add");
        listenTo.add("a");
    }

    Scanner scanner = new Scanner(System.in);

    public AddAction(MasterControl masterControl, LineStorage lineStorage) {
        super(masterControl, lineStorage);
    }

    @Override
    public void handle(String actionType) {
        if (!listenTo.contains(actionType.toLowerCase())) return;

        String line = scanner.nextLine();

        int index = lineStorage.addLine(new Line(line));

        this.masterControl.getOutput().output("Line added to index: " + index);
    }

}
