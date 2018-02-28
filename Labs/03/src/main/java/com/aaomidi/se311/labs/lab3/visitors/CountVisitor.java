package com.aaomidi.se311.labs.lab3.visitors;

import com.aaomidi.se311.labs.lab3.bean.Directory;
import com.aaomidi.se311.labs.lab3.bean.File;
import com.aaomidi.se311.labs.lab3.bean.Visitor;

public class CountVisitor implements Visitor {
    private int fileCount = 0;
    private int level = 0;

    @Override
    public void preVisitDirectory(Directory file) {
        level++;
    }

    @Override
    public void visitFile(File file) {
        fileCount++;
    }

    @Override
    public void postVisitDirectory(Directory dir) {
        level--;
        if (level == 0) {
            System.out.printf("Directory %s: %d files%n", dir.getName(), fileCount);
        }
    }
}
