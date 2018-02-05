package com.aaomidi.se311.homework.hw1.bean.io.output;

import java.io.PrintStream;
import java.util.stream.Stream;

public class ConsoleOutput implements Output {
    private final PrintStream out = System.out;

    @Override
    public void output(Stream<String> input) {
        input.forEach(out::println);
    }
}
