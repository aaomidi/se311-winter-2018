package com.aaomidi.se311.homework.hw3.manager;

import com.aaomidi.se311.homework.hw3.bean.Line;

import java.util.List;

public interface Algorithm {
    List<Line> apply(List<Line> input);
}
