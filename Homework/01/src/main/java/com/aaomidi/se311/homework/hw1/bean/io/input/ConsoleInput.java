package com.aaomidi.se311.homework.hw1.bean.io.input;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleInput implements Input {
    private final InputStream input = System.in;

    @Override
    public Stream<String> getInput() {
        Scanner scanner = new Scanner(input);
        List<String> input = new ArrayList<>();
        while (true) {
            String str = scanner.nextLine();
            if (str == null || str.isEmpty()) break;
            input.add(str);
        }
        return input.stream();
    }
}
