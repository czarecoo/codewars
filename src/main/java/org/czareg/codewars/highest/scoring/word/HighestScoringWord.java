package org.czareg.codewars.highest.scoring.word;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
For example, the score of abad is 8 (1 + 2 + 1 + 4).
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid.
 */
@UtilityClass
public class HighestScoringWord {

    private static final Map<Character, Integer> SCORING_MAP = prepareScoringMap();

    public static String high(@NonNull String wordsString) {
        return Arrays.stream(wordsString.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.summingInt(HighestScoringWord::score)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Integer::compareTo))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    private static int score(@NonNull String word) {
        return word.chars()
                .reduce(0, (result, element) -> result + SCORING_MAP.get((char) element));
    }

    private static Map<Character, Integer> prepareScoringMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (int c = 'a', i = 1; i <= 26; c++, i++) {
            map.put((char) c, i);
        }
        return map;
    }
}
