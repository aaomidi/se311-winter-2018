package com.aaomidi.se311.homework.hw1.bean;

public interface Pipe<E> {
    boolean put(E obj);

    E get() throws InterruptedException;
}