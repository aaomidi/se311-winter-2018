package com.aaomidi.se311.homework.hw2.bean.config;

import com.aaomidi.se311.homework.hw2.bean.Line;
import com.aaomidi.se311.homework.hw2.bean.filter.Filter;
import com.aaomidi.se311.homework.hw2.filters.*;

import java.util.function.Function;

public enum Pipeline {
    INPUT_FILTER(context -> {
        return new InputFilter(context.getOutPipe(), context.getInput());
    }),
    CIRCULAR_SHIFTER(context -> {
        return new CircularShifter(context.getInPipe(), context.getOutPipe());
    }),
    ALPHABETIZER(context -> {
        return new Alphabetizer(context.getInPipe(), context.getOutPipe());
    }),
    OUTPUT_FILTER(context -> {
        return new OutputFilter(context.getInPipe(), context.getOutPipe(), context.getOutput());
    }),
    UPPER_CASE_FILTER(context -> {
        return new UpperCaseFilter(context.getInPipe(), context.getOutPipe());
    });

    public Function<Context, Filter<Line>> getFunction() {
        return function;
    }

    private final Function<Context, Filter<Line>> function;

    Pipeline(Function<Context, Filter<Line>> function) {
        this.function = function;
    }
}
