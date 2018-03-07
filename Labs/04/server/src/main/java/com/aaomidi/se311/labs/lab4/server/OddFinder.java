package com.aaomidi.se311.labs.lab4.server;

import com.aaomidi.se311.labs.lab4.commons.Payload;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OddFinder {

    public static Payload filterOdds(Payload payload) {
        ArrayList<Integer> odds = payload.getList();
        ArrayList<Integer> result = odds.stream().filter(integer -> (integer & 1) != 0).collect(Collectors.toCollection(ArrayList::new));

        return new Payload(result);
    }
}
