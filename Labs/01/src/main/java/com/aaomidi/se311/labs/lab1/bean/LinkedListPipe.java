package com.aaomidi.se311.labs.lab1.bean;

import java.util.LinkedList;

public class LinkedListPipe<E> implements Pipe<E> {

    // LinkedList makes more sense here.
    private LinkedList<E> buffer = new LinkedList<>();

    public synchronized boolean put(E obj) {
        boolean bAdded = buffer.add(obj);
        notify();
        return bAdded;
    }

    public synchronized E get() throws InterruptedException {
        while (buffer.isEmpty()) wait(); //pipe empty - wait
        return buffer.removeFirst();
    }
}
