package com.aaomidi.se311.labs.lab4.commons;

import java.util.ArrayList;


public class Payload {
    private final ArrayList<Integer> list;

    public Payload(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "list=" + list +
                '}';
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
