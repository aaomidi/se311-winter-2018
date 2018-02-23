package com.aaomidi.se311.homework.hw3.bean.io.actions;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.Line;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;
import com.aaomidi.se311.homework.hw3.bean.io.Event;
import com.aaomidi.se311.homework.hw3.manager.Algorithm;
import com.aaomidi.se311.homework.hw3.manager.CircularShifter;
import com.aaomidi.se311.homework.hw3.manager.Sorter;

import java.util.HashSet;
import java.util.List;

public class PrintEvent extends Event {
    private final static HashSet<String> listenTo;

    static {
        listenTo = new HashSet<>();
        listenTo.add("print");
        listenTo.add("prt");
        listenTo.add("p");
    }

    public PrintEvent(MasterControl masterControl, LineStorage lineStorage) {
        super(masterControl, lineStorage);
    }

    @Override
    public void handle(String actionType) {
        if (!listenTo.contains(actionType.toLowerCase())) return;
        List<Line> lines = lineStorage.getLines();

        Algorithm shifter = new CircularShifter();
        Algorithm sorter = new Sorter();

        // Chain pattern
        List<Line> outputList = sorter.apply(shifter.apply(lines));
        masterControl.getOutput().output(outputList.stream().map(Line::getSentence));
    }
}
