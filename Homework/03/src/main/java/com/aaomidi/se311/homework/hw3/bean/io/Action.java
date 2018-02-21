package com.aaomidi.se311.homework.hw3.bean.io;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;

public abstract class Action {
    protected final MasterControl masterControl;
    protected final LineStorage lineStorage;

    protected Action(MasterControl masterControl, LineStorage lineStorage) {
        this.masterControl = masterControl;
        this.lineStorage = lineStorage;
    }


    public abstract void handle(String actionType);
}
