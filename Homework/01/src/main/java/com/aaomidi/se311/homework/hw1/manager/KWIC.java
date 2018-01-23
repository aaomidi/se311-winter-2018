package com.aaomidi.se311.homework.hw1.manager;

import com.aaomidi.se311.homework.hw1.bean.Sentence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KWIC {

    public List<Sentence> apply(List<String> list) {
        List<Sentence> sentences = new ArrayList<>(list.size());
        for (String str : list) {
            Sentence sentence = new Sentence(str);
            sentences.addAll(sentence.circularShift());
        }

        Collections.sort(sentences);

        return sentences;
    }
}
