package com.aaomidi.se311.labs.lab4.commons.api;

import java.util.ArrayList;
import java.util.List;


public class Payload {
    private final List<Integer> list;

    public Payload(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "list=" + list +
                '}';
    }

    public List<Integer> getList() {
        return list;
    }
}
