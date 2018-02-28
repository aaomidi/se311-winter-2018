package com.aaomidi.se311.labs.lab3.bean;

public interface Visitor {

    default void preVisitDirectory(Directory file) {
    }

    default void visitFile(File file) {
    }

    default void postVisitDirectory(Directory dir) {
    }


}
