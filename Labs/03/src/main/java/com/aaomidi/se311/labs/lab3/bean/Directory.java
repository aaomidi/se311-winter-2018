package com.aaomidi.se311.labs.lab3.bean;

import java.util.HashSet;
import java.util.Set;

public class Directory implements FileSystemEntity {
    private final String name;
    private final Set<FileSystemEntity> files = new HashSet<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.preVisitDirectory(this);
        files.forEach(f -> f.accept(v));
        v.postVisitDirectory(this);
    }

    public void add(FileSystemEntity entity) {
        files.add(entity);
    }

    public void remove(FileSystemEntity entity) {
        files.remove(entity);
    }

    public Set<FileSystemEntity> getChildren() {
        return files;
    }
}
