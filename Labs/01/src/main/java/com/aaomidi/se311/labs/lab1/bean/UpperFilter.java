package com.aaomidi.se311.labs.lab1.bean;

public class UpperFilter extends Filter<String> {
    public UpperFilter(Pipe<String> input, Pipe<String> output) {
        super(input, output);
    }

    @Override
    protected void transform() {
        while (true) {
            try {
                output.put(input.get().toUpperCase());
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
