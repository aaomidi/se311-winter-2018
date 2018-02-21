package com.aaomidi.se311.homework.hw3.bean.io.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileInput implements Input {
    private final Path path;

    public FileInput(Path path) {
        this.path = path;
    }

    @Override
    public Stream<String> getInput() {
        try {
            return Files.readAllLines(path).stream();
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }
}
