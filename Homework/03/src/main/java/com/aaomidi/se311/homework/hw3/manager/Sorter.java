package com.aaomidi.se311.homework.hw3.manager;

import com.aaomidi.se311.homework.hw3.bean.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter implements Algorithm {
    @Override
    public List<Line> apply(List<Line> input) {
        List<Line> list = new ArrayList<>(input);
        Collections.sort(list);
        return list;
    }
}
