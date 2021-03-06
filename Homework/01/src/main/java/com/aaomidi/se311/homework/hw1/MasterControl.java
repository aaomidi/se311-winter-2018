package com.aaomidi.se311.homework.hw1;

import com.aaomidi.se311.homework.hw1.bean.Line;
import com.aaomidi.se311.homework.hw1.bean.config.Configuration;
import com.aaomidi.se311.homework.hw1.bean.io.input.Input;
import com.aaomidi.se311.homework.hw1.bean.io.output.Output;
import com.aaomidi.se311.homework.hw1.manager.Algorithm;
import com.aaomidi.se311.homework.hw1.manager.CircularShifter;
import com.aaomidi.se311.homework.hw1.manager.Sorter;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MasterControl {
    private final Gson gson = new Gson();

    public MasterControl(String... args) {
        if (args.length == 0) {
            System.out.println("Please enter path to configuration as an argument.");
            System.exit(0);
        }

        Configuration configuration = setupConfiguration(args[0]);


        Input input = configuration.getInput().createInput();
        Output output = configuration.getOutput().createOutput();

        if (input == null || output == null) {
            System.out.println("Issues with either input or output.");
            System.exit(-1);
        }

        // Gets the input based on the configuration.
        Stream<String> stringInput = input.getInput();
        List<Line> lines = Line.convert(stringInput.collect(Collectors.toList()));

        Algorithm shifter = new CircularShifter();
        Algorithm sorter = new Sorter();

        // Chain pattern
        List<Line> outputList = sorter.apply(shifter.apply(lines));

        output.output(outputList.stream().map(Line::getSentence));
    }

    public static void main(String... args) {
        new MasterControl(args);
    }

    public Configuration setupConfiguration(String configurationPath) {
        Configuration configuration = null;
        try {
            FileReader reader = new FileReader(new File(configurationPath));
            configuration = gson.fromJson(reader, Configuration.class);
            return configuration;
        } catch (Exception ex) {
            System.out.println("Problems reading the configuration: ");
            ex.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
