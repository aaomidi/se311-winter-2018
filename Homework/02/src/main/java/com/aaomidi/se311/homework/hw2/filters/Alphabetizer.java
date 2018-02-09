package com.aaomidi.se311.homework.hw2.filters;

import com.aaomidi.se311.homework.hw2.bean.Line;
import com.aaomidi.se311.homework.hw2.bean.Pipe;
import com.aaomidi.se311.homework.hw2.bean.filter.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer extends Filter<Line> {
    private final List<Line> buffer = new ArrayList<>();

    public Alphabetizer(Pipe<Line> input, Pipe<Line> output) {
        super(input, output);
    }

    @Override
    public void transform() {
        while (true) {
            Line line;
            try {
                line = input.get();
                if (line == null || line == Line.FOOTER) {
                    break;
                }

                buffer.add(line);
            } catch (Exception ex) {
                break;
            }
        }
        Collections.sort(buffer);
        buffer.forEach(output::put);
        output.put(Line.FOOTER);
    }
}
