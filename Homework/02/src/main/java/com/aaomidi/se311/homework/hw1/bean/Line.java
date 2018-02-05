package com.aaomidi.se311.homework.hw1.bean;

import java.util.List;
import java.util.stream.Collectors;

public class Line implements Comparable<Line> {
    private final String sentence;

    public Line(String sentence) {
        this.sentence = sentence;
    }

    public Line(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        this.sentence = sb.toString();
    }

    public static List<Line> convert(List<String> list) {
        return list.stream().map(Line::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Line{" +
                "sentence='" + sentence + '\'' +
                '}' + "\n";
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public int compareTo(Line o) {
        return this.getSentence().toLowerCase().compareTo(o.getSentence().toLowerCase());
    }
}
