package com.aaomidi.se311.labs.lab1.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Generator extends Filter<String> {
    private final Path path;


    public Generator(Pipe<String> output, String filePath) throws Exception {
        super(null, output);
        path = Paths.get(filePath);
        if (path == null) {
            throw new Exception("File not found.");
        }
    }

    @Override
    protected void transform() {
        try {
            Files.lines(path).forEach(output::put);
        } catch (IOException e) {
            System.out.println("Unable to read lines.");
            e.printStackTrace();
        }
    }
}
