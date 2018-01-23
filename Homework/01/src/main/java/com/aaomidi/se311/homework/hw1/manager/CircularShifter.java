package com.aaomidi.se311.homework.hw1.manager;

import com.aaomidi.se311.homework.hw1.bean.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CircularShifter implements Algorithm {

    public List<Line> apply(List<Line> list) {
        List<Line> lines = new ArrayList<>(list.size());

        for (Line line : list) {
            lines.addAll(shift(line));
        }

        Collections.sort(lines);

        return lines;
    }

    private List<Line> shift(Line line) {
        String sentence = line.getSentence();
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split("[^a-zA-Z]+")));

        List<Line> result = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            words.add(words.remove(0));
            result.add(new Line(words));
        }

        return result;
    }
}
