package org.czareg.codewars.inspiring.strings;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;

import static java.util.Arrays.stream;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

/*
Given a string of space separated words, return the longest word.
If there are multiple longest words, return the rightmost longest word.

Examples
"red white blue"  =>  "white"
"red blue gold"   =>  "gold"
 */
@UtilityClass
public class InspiringStrings {

    public static String longestWord(@NonNull String wordString) {
        return stream(wordString.split(" "))
                .collect(groupingBy(String::length, toCollection(LinkedList::new)))
                .entrySet()
                .stream()
                .max(comparingByKey())
                .orElseThrow()
                .getValue()
                .getLast();
    }
}
