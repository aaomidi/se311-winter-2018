package com.aaomidi.se311.homework.hw3.bean.config;

public class Configuration {
    public InputConfiguration getInput() {
        return input;
    }

    public OutputConfiguration getOutput() {
        return output;
    }

    private final InputConfiguration input;
    private final OutputConfiguration output;

    public Configuration(InputConfiguration input, OutputConfiguration output) {
        this.input = input;
        this.output = output;
    }
}
