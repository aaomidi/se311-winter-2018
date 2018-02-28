package com.aaomidi.se311.labs.lab3.bean;

import java.util.Date;

public class File implements FileSystemEntity {
    private final String name;
    private final long size;
    private final Date date;

    public File(String name, long size, Date fileCreation) {
        this.name = name;
        this.size = size;
        this.date = fileCreation;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visitFile(this);
    }

    public Date getDate() {
        return date;
    }

    public long getSize() {
        return size;
    }
}

