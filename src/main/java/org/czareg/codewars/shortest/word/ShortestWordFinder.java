package org.czareg.codewars.shortest.word;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Simple, given a string of words, return the length of the shortest word(s).

String will never be empty and you do not need to account for different data types.
 */
@UtilityClass
public class ShortestWordFinder {

    public static int findShort(String s) {
        return Arrays.stream(s.split(" "))
                .map(String::length)
                .min(Integer::compareTo)
                .orElseThrow();
    }
}
