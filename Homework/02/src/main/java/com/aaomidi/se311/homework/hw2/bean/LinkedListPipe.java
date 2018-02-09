package com.aaomidi.se311.homework.hw2.bean;

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
        //System.out.println(buffer);
        while (buffer.isEmpty()) wait(); //pipe empty - wait
        return buffer.removeFirst();
    }
}
