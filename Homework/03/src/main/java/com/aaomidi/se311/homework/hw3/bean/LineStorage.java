package com.aaomidi.se311.homework.hw3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineStorage {
    private final List<Line> lines = new ArrayList<>();

    public int addLine(Line line) {
        if (lines.add(line))
            return lines.size();

        return -1;
    }

    public boolean deleteLine(int index) {
        if (index < 0 || index >= lines.size()) return false;

        lines.remove(index);
        return true;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
