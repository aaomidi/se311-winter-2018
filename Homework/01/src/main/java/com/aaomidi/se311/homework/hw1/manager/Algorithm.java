package com.aaomidi.se311.homework.hw1.manager;

import com.aaomidi.se311.homework.hw1.bean.Line;

import java.util.List;

public interface Algorithm {
    List<Line> apply(List<Line> input);
}
