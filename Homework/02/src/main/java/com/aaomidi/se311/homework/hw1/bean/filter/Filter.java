package com.aaomidi.se311.homework.hw1.bean.filter;

import com.aaomidi.se311.homework.hw1.bean.Pipe;

public abstract class Filter<E> implements Runnable {

    protected Pipe<E> input;
    protected Pipe<E> output;
    private boolean isStarted;


    public Filter(Pipe<E> input, Pipe<E> output) {
        this.input = input;
        this.output = output;
        isStarted = false;
    }


    @Override
    public void run() {
        transform();
    }

    public void start() {
        if (!isStarted) {
            isStarted = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        isStarted = false;

    }

    public abstract void transform();
}
