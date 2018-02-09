package com.aaomidi.se311.homework.hw2.filters;

import com.aaomidi.se311.homework.hw2.bean.Line;
import com.aaomidi.se311.homework.hw2.bean.Pipe;
import com.aaomidi.se311.homework.hw2.bean.filter.Initializer;
import com.aaomidi.se311.homework.hw2.bean.io.input.Input;


public class InputFilter extends Initializer<Line> {
    private final Input input;

    public InputFilter(Pipe<Line> output, Input input) {
        super(output);
        this.input = input;
    }

    @Override
    public void transform() {
        input.getInput().forEach(s -> {
            if (s == null) return;
            Line line = new Line(s);
            output.put(line);
        });
        output.put(Line.FOOTER);
    }
}
