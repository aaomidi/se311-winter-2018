package com.aaomidi.se311.labs.lab3;

import com.aaomidi.se311.labs.lab3.bean.Directory;
import com.aaomidi.se311.labs.lab3.bean.File;
import com.aaomidi.se311.labs.lab3.bean.Visitor;
import com.aaomidi.se311.labs.lab3.visitors.CountVisitor;
import com.aaomidi.se311.labs.lab3.visitors.DateVisitor;
import com.aaomidi.se311.labs.lab3.visitors.PrinterVisitor;

import java.util.Date;

public class MasterControl {
    public static void main(String[] args) {
        Directory root = new Directory("/");
        root.add(new File("test.txt", 12311, new Date(1519762153000L)));
        root.add(new File("test2.txt", 12341, new Date(1319762153000L)));
        root.add(new File("test3.txt", 131, new Date(1419762153000L)));

        Directory personalDir = new Directory("school_work/");
        root.add(personalDir);

        personalDir.add(new File("Homework1.txt", 1211, new Date(1619762153000L)));

        Directory innerDirectory = new Directory("job_applications/");
        personalDir.add(innerDirectory);

        innerDirectory.add(new File("some_company.md", 122131, new Date(1619762153000L)));
        innerDirectory.add(new Directory("empty_dir/"));
        innerDirectory.add(new File("moar_file.md", 12756, new Date(1312768153000L)));

        Visitor printer = new PrinterVisitor();
        Visitor counter = new CountVisitor();
        Visitor dateVisitor = new DateVisitor();

        System.out.println("Traversal:");
        root.accept(printer);
        System.out.println("\n Count of directory:");
        root.accept(counter);
        System.out.println("\nLatest file(s):");
        root.accept(dateVisitor);
    }
}
