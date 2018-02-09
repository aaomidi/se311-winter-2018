package com.aaomidi.se311.homework.hw2.bean.config;

import com.aaomidi.se311.homework.hw2.bean.Line;
import com.aaomidi.se311.homework.hw2.bean.LinkedListPipe;
import com.aaomidi.se311.homework.hw2.bean.Pipe;
import com.aaomidi.se311.homework.hw2.bean.filter.Filter;
import com.aaomidi.se311.homework.hw2.bean.io.input.Input;
import com.aaomidi.se311.homework.hw2.bean.io.output.Output;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private final InputConfiguration input;
    private final OutputConfiguration output;
    private final List<Pipeline> pipeline;

    public Configuration(InputConfiguration input, OutputConfiguration output, List<Pipeline> pipeline) {
        this.input = input;
        this.output = output;
        this.pipeline = pipeline;
    }

    public InputConfiguration getInput() {
        return input;
    }

    public OutputConfiguration getOutput() {
        return output;
    }

    public List<Filter<Line>> getPipeline() {
        List<Filter<Line>> filters = new ArrayList<>(this.pipeline.size());
        Input in = input.createInput();
        Output out = output.createOutput();

        if (in == null || out == null) {
            System.out.println("Issues with either input or output.");
            System.exit(-1);
        }

        Pipe<Line> p1 = new LinkedListPipe<>();
        Pipe<Line> p2 = new LinkedListPipe<>();
        for (Pipeline pipeline : this.pipeline) {
            Context context = new Context(p1, p2, in, out);
            filters.add(pipeline.getFunction().apply(context));
            p1 = p2;
            p2 = new LinkedListPipe<>();
        }
        return filters;
    }
}
