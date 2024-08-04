package org.czareg.codewars.my.language.skills;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;

@UtilityClass
public class MyLanguages {

    private static final int THRESHOLD = 60;

    public static List<String> myLanguages(final Map<String, Integer> results) {
        return results.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= THRESHOLD)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }
}
