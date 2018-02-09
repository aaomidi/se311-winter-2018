package com.aaomidi.se311.homework.hw1;

import com.aaomidi.se311.homework.hw1.bean.config.Configuration;
import com.aaomidi.se311.homework.hw1.bean.filter.Filter;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;

public class MasterControl {
    private final Gson gson = new Gson();

    public MasterControl(String... args) {
        if (args.length == 0) {
            System.out.println("Please enter path to configuration as an argument.");
            System.exit(0);
        }

        Configuration configuration = setupConfiguration(args[0]);

        for (Filter f : configuration.getPipeline()) {
            f.start();
        }
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
