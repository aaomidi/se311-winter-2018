package com.aaomidi.se311.homework.hw1.bean.config;

import com.aaomidi.se311.homework.hw1.bean.Line;
import com.aaomidi.se311.homework.hw1.bean.Pipe;
import com.aaomidi.se311.homework.hw1.bean.io.input.Input;
import com.aaomidi.se311.homework.hw1.bean.io.output.Output;

public class Context {
    private final Pipe<Line> inPipe;
    private final Pipe<Line> outPipe;
    private final Input input;
    private final Output output;

    public Context(Pipe<Line> inPipe, Pipe<Line> outPipe, Input input, Output output) {
        this.inPipe = inPipe;
        this.outPipe = outPipe;
        this.input = input;
        this.output = output;
    }

    public Pipe<Line> getInPipe() {

        return inPipe;
    }

    public Pipe<Line> getOutPipe() {
        return outPipe;
    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }
}
