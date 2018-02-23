package com.aaomidi.se311.homework.hw3.bean.io.actions;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;
import com.aaomidi.se311.homework.hw3.bean.io.Event;

import java.util.HashSet;

public class QuitEvent extends Event {
    private final static HashSet<String> listenTo;

    static {
        listenTo = new HashSet<>();
        listenTo.add("quit");
        listenTo.add("q");
    }

    public QuitEvent(MasterControl masterControl, LineStorage lineStorage) {
        super(masterControl, lineStorage);
    }

    @Override
    public void handle(String actionType) {
        if (!listenTo.contains(actionType.toLowerCase())) return;
        System.exit(0);
    }
}
