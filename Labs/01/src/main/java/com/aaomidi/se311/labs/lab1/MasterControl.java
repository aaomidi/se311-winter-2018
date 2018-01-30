package com.aaomidi.se311.labs.lab1;

import com.aaomidi.se311.labs.lab1.bean.*;

import java.io.IOException;

public class MasterControl {
    public MasterControl(String... args) {
        if (args.length == 0) {
            System.out.println("Not enough arguments.");
            System.exit(-1);
            return;
        }
        // Create pipes
        Pipe<String> inputToUpperPipe = new LinkedListPipe<>();
        Pipe<String> upperToPrinterPipe = new LinkedListPipe<>();

        Filter<String> generatorFilter;
        try {
            generatorFilter = new Generator(inputToUpperPipe, args[0]);
        } catch (IOException e) {
            System.out.println("File not found.");
            System.exit(-1);
            return;
        }

        Filter<String> upperFilter = new UpperFilter(inputToUpperPipe, upperToPrinterPipe);
        Filter<String> printerFilter = new PrinterFilter(upperToPrinterPipe);


        generatorFilter.start();
        upperFilter.start();
        printerFilter.start();


        //start the generator and the filter
    }

    public static void main(String args[]) {

        new MasterControl(args);
    }
}
