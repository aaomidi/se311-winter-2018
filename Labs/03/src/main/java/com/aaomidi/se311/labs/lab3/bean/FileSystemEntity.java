package com.aaomidi.se311.labs.lab3.bean;

import java.util.Set;

public interface FileSystemEntity {

    String getName();

    void accept(Visitor v);
}
