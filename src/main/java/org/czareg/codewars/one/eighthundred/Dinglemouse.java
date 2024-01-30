package org.czareg.codewars.one.eighthundred;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class Dinglemouse {

    private static final Map<Integer, String> PHONEWORDS = Map.of(
            2, "ABC",
            3, "DEF",
            4, "GHI",
            5, "JKL",
            6, "MNO",
            7, "PQRS",
            8, "TUV",
            9, "WXYZ"
    );

    public static Set<String> check1800(final String str) {
        String[] split = str.split("-");

        String whole = split[2] + split[3];
        int firstInteger = toInteger(whole.substring(0, 4));
        int secondInteger = toInteger(whole.substring(4));
        int thirdInteger = toInteger(whole.substring(0, 3));
        int fourthInteger = toInteger(whole.substring(3));

        List<Integer> correct = List.of(firstInteger, secondInteger, thirdInteger, fourthInteger);
        Map<Integer, List<String>> wordsMatchingInteger = Arrays.stream(Preloaded.WORDS)
                .filter(word -> {
                    Integer integer = toInteger(word);
                    return correct.contains(integer);
                })
                .collect(Collectors.groupingBy(Dinglemouse::toInteger));

        HashSet<String> results = new HashSet<>();
        combineWords(wordsMatchingInteger, firstInteger, secondInteger, results);
        combineWords(wordsMatchingInteger, thirdInteger, fourthInteger, results);
        return results;
    }

    private static Integer toInteger(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            for (Map.Entry<Integer, String> integerStringEntry : PHONEWORDS.entrySet()) {
                if (integerStringEntry.getValue().contains(String.valueOf(c))) {
                    Integer key = integerStringEntry.getKey();
                    if (key != null) {
                        stringBuilder.append(key);
                    }
                }
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    private static void combineWords(Map<Integer, List<String>> collect, int firstInteger, int secondInteger, HashSet<String> hashSet) {
        for (String firstString : collect.getOrDefault(firstInteger, Collections.emptyList())) {
            for (String secondString : collect.getOrDefault(secondInteger, Collections.emptyList())) {
                hashSet.add("1-800-%s-%s".formatted(firstString, secondString));
            }
        }
    }
}
