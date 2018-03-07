package com.aaomidi.se311.labs.lab4.server;

import com.aaomidi.se311.labs.lab4.commons.api.Payload;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OddFinder {

    public static Payload filterOdds(Payload payload) {
        List<Integer> odds = payload.getList();
        List<Integer> result = odds.stream().filter(val -> (val & 1) != 0).collect(Collectors.toCollection(ArrayList::new));

        return new Payload(result);
    }
}
