package com.aaomidi.se311.homework.hw3.bean.io.actions;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;
import com.aaomidi.se311.homework.hw3.bean.io.Event;

import java.util.HashSet;
import java.util.Scanner;

public class DeleteEvent extends Event {
    private final static HashSet<String> listenTo;

    static {
        listenTo = new HashSet<>();
        listenTo.add("del");
        listenTo.add("d");
        listenTo.add("delete");
    }

    Scanner scanner = new Scanner(System.in);

    public DeleteEvent(MasterControl masterControl, LineStorage lineStorage) {
        super(masterControl, lineStorage);
    }

    @Override
    public void handle(String actionType) {
        if (!listenTo.contains(actionType.toLowerCase())) return;
        masterControl.getOutput().output("Enter line number to delete.");
        while (true) {
            try {
                String line = scanner.nextLine();
                Integer lineNumber = Integer.valueOf(line);

                if (lineStorage.deleteLine(lineNumber - 1)) {
                    masterControl.getOutput().output("Successfully deleted line.");
                    return;
                } else {
                    masterControl.getOutput().output(String.format("Line number %d doesn't exist.", lineNumber));
                }
            } catch (Exception ex) {
                masterControl.getOutput().output("Hey there! That wasn't a number. Try again.");
            }
        }
    }
}
