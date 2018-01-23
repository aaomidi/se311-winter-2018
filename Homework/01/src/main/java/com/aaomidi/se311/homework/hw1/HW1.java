package com.aaomidi.se311.homework.hw1;

import com.aaomidi.se311.homework.hw1.bean.Sentence;
import com.aaomidi.se311.homework.hw1.bean.config.Configuration;
import com.aaomidi.se311.homework.hw1.bean.io.input.Input;
import com.aaomidi.se311.homework.hw1.bean.io.output.Output;
import com.aaomidi.se311.homework.hw1.manager.KWIC;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW1 {
    private final Gson gson = new Gson();

    public HW1(String... args) {
        if (args.length == 0) {
            System.out.println("Please enter path to configuration as an argument.");
            System.exit(0);
        }
        String configurationPath = args[0];
        Configuration configuration = null;
        try {
            FileReader reader = new FileReader(new File(configurationPath));
            configuration = gson.fromJson(reader, Configuration.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

        Input input = configuration.getInput().createInput();
        Output output = configuration.getOutput().createOutput();

        Stream<String> stringInput = input.getInput();

        KWIC kwic = new KWIC();
        List<Sentence> outputList = kwic.apply(stringInput.collect(Collectors.toList()));

        output.output(outputList.stream().map(Sentence::getSentence));
    }

    public static void main(String... args) {
        new HW1(args);
    }
}
