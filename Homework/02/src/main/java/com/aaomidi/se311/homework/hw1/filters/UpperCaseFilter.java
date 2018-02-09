package com.aaomidi.se311.homework.hw1.filters;

import com.aaomidi.se311.homework.hw1.bean.Line;
import com.aaomidi.se311.homework.hw1.bean.Pipe;
import com.aaomidi.se311.homework.hw1.bean.filter.Filter;

public class UpperCaseFilter extends Filter<Line> {
    public UpperCaseFilter(Pipe<Line> input, Pipe<Line> output) {
        super(input, output);
    }

    @Override
    public void transform() {
        while (true) {
            try {
                Line line = input.get();
                if (line == null || line == Line.FOOTER) {
                    output.put(Line.FOOTER);
                    break;
                }

                output.put(new Line(line.getSentence().toUpperCase()));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
