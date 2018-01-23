package com.aaomidi.se311.homework.hw1.bean.io.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOutput implements Output {
    private final Path path;

    public FileOutput(Path path) {
        this.path = path;
    }


    @Override
    public void output(Stream<String> input) {
        try {
            Files.write(path, input.collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
