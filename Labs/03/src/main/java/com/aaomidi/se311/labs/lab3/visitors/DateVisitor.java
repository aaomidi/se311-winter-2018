package com.aaomidi.se311.labs.lab3.visitors;

import com.aaomidi.se311.labs.lab3.bean.Directory;
import com.aaomidi.se311.labs.lab3.bean.File;
import com.aaomidi.se311.labs.lab3.bean.Visitor;
import com.aaomidi.se311.labs.lab3.util.FileUtility;

import java.util.LinkedList;

public class DateVisitor implements Visitor {
    private final LinkedList<File> latestFile = new LinkedList<>();
    private int level = 0;

    @Override
    public void preVisitDirectory(Directory file) {
        level++;
    }

    @Override
    public void visitFile(File file) {
        File oldFile;
        if (latestFile.size() == 0) {
            oldFile = null;
        } else {
            oldFile = latestFile.getFirst();
        }

        if (oldFile == null) {
            latestFile.add(file);
        } else {
            int compare = file.getDate().compareTo(oldFile.getDate());
            if (compare >= 0) {
                if (compare > 0) {
                    latestFile.clear();
                }
                latestFile.add(file);
            }
        }
    }

    @Override
    public void postVisitDirectory(Directory dir) {
        level--;
        if (level == 0) {
            for (File file : latestFile) {
                System.out.println(FileUtility.formatFile(file));
            }
        }
    }

}
