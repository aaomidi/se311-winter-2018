package com.aaomidi.se311.homework.hw3.bean.config;

import com.aaomidi.se311.homework.hw3.bean.io.output.ConsoleOutput;
import com.aaomidi.se311.homework.hw3.bean.io.output.FileOutput;
import com.aaomidi.se311.homework.hw3.bean.io.output.Output;

import java.nio.file.Paths;

public class OutputConfiguration {
    private final Type type;
    private final String path;

    public OutputConfiguration(Type type, String outputPath) {
        this.type = type;
        this.path = outputPath;
    }

    public Output createOutput() {
        switch (type) {
            case FILE:
                try {
                    return new FileOutput(Paths.get(path));
                } catch (Exception ex) {
                    System.out.println("Bad configuration - output.");
                }
            case CONSOLE:
                return new ConsoleOutput();
        }
        return null;
    }
}
