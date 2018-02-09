package com.aaomidi.se311.homework.hw1.filters;

import com.aaomidi.se311.homework.hw1.bean.Line;
import com.aaomidi.se311.homework.hw1.bean.Pipe;
import com.aaomidi.se311.homework.hw1.bean.filter.Filter;
import com.aaomidi.se311.homework.hw1.bean.io.output.Output;

public class OutputFilter extends Filter<Line> {
    private final Output printer;

    public OutputFilter(Pipe<Line> input, Pipe<Line> output, Output printer) {
        super(input, output);
        this.printer = printer;
    }

    @Override
    public void transform() {
        while (true) {
            Line line;
            try {
                line = input.get();
                if (line == null || line == Line.FOOTER) {
                    output.put(Line.FOOTER);
                    break;
                }

                printer.output(line.getSentence());
                output.put(line);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
}
