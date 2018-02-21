package com.aaomidi.se311.homework.hw3.bean.config;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.io.input.ConsoleInput;
import com.aaomidi.se311.homework.hw3.bean.io.input.FileInput;
import com.aaomidi.se311.homework.hw3.bean.io.input.Input;

import java.nio.file.Paths;

public class InputConfiguration {
    private final Type type;
    private final String path;

    public InputConfiguration(Type type, String path) {
        this.type = type;
        this.path = path;
    }

    public Input createInput(MasterControl masterControl) {
        switch (type) {
            case FILE:
                try {
                    return new FileInput(Paths.get(path));
                } catch (Exception ex) {
                    System.out.println("Bad configuration - input.");
                }
                break;
            case CONSOLE: {
                ConsoleInput input = new ConsoleInput();
                input.registerActions(masterControl);
                return input;
            }
        }
        return null;
    }
}
