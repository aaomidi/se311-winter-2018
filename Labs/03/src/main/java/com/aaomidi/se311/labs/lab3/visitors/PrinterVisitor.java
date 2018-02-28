package com.aaomidi.se311.labs.lab3.visitors;

import com.aaomidi.se311.labs.lab3.bean.Directory;
import com.aaomidi.se311.labs.lab3.bean.File;
import com.aaomidi.se311.labs.lab3.bean.Visitor;
import com.aaomidi.se311.labs.lab3.util.FileUtility;

public class PrinterVisitor implements Visitor {

    private int level = 0;

    @Override
    public void preVisitDirectory(Directory file) {
        printLevel();
        System.out.println(FileUtility.formatDirectory(file));
        level++;
    }

    @Override
    public void visitFile(File file) {
        printLevel();
        System.out.println(FileUtility.formatFile(file));
    }

    @Override
    public void postVisitDirectory(Directory dir) {
        level--;
    }

    private void printLevel() {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
    }
}
