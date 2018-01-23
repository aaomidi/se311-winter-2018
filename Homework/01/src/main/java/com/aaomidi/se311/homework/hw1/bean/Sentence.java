package com.aaomidi.se311.homework.hw1.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence implements Comparable<Sentence> {
    private final String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        this.sentence = sb.toString();
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                '}'+"\n";
    }

    public List<Sentence> circularShift() {
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split("[^a-zA-Z]+")));

        List<Sentence> result = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            words.add(words.remove(0));
            result.add(new Sentence(words));
        }

        return result;
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public int compareTo(Sentence o) {
        return this.getSentence().toLowerCase().compareTo(o.getSentence().toLowerCase());
    }
}
