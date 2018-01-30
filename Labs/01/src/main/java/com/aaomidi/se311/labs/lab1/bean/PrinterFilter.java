package com.aaomidi.se311.labs.lab1.bean;

public class PrinterFilter extends Filter<String> {


    public PrinterFilter(Pipe<String> input) {
        super(input, null);
    }

    @Override
    protected void transform() {
        while (true) {
            String str = null;
            try {
                str = input.get();
            } catch (InterruptedException e) {
                break;
            }
            System.out.println(str);
        }
    }
}
