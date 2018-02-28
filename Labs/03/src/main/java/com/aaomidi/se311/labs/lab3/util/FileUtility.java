package com.aaomidi.se311.labs.lab3.util;

import com.aaomidi.se311.labs.lab3.bean.Directory;
import com.aaomidi.se311.labs.lab3.bean.File;

import java.text.SimpleDateFormat;

public class FileUtility {
    private final static SimpleDateFormat SDF = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static String formatFile(File file) {
        return String.format("File: %s - %d bytes - %s", file.getName(), file.getSize(), SDF.format(file.getDate()));

    }

    public static String formatDirectory(Directory directory) {
        return String.format("Directory: %s", directory.getName());
    }
}
