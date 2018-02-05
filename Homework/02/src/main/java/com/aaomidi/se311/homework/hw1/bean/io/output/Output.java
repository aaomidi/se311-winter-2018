package com.aaomidi.se311.homework.hw1.bean.io.output;

import java.util.stream.Stream;

public interface Output {
    void output(Stream<String> input);

    default void output(String... input) {
        Stream<String> stream = Stream.of(input);
        output(stream);
    }
}
