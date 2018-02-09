package com.aaomidi.se311.homework.hw2.bean.filter;

import com.aaomidi.se311.homework.hw2.bean.Pipe;

public abstract class Initializer<E> extends Filter<E> {
    public Initializer(Pipe<E> output) {
        super(null, output);
    }
}
