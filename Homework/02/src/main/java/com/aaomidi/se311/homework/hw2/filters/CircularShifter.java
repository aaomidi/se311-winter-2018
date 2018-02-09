package com.aaomidi.se311.homework.hw2.filters;

import com.aaomidi.se311.homework.hw2.bean.Line;
import com.aaomidi.se311.homework.hw2.bean.Pipe;
import com.aaomidi.se311.homework.hw2.bean.filter.Filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter extends Filter<Line> {

    public CircularShifter(Pipe<Line> input, Pipe<Line> output) {
        super(input, output);
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

                shift(line).forEach(output::put);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
}
