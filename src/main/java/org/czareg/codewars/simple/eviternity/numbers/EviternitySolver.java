package org.czareg.codewars.simple.eviternity.numbers;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
An eviternity number is a number which:

contains only digits 8, 5 and 3, and
the count of the digit 8 >= count of digit 5 >= count of digit 3.
The first few eviternity numbers are as follows.

[8, 58, 85, 88, 358, 385, 538, 583, 588, 835, 853, 858, 885, 888]
You will be given two integers, a and b, and your task is to return the number of eviternity numbers in the range >= a and < b.

For example:
solve(0,1000) = 14, because they are [8, 58, 85, 88, 358, 385, 538, 583, 588, 835, 853, 858, 885, 888]
The upper bound will not exceed 500,000.
 */
@UtilityClass
public class EviternitySolver {

    private static final List<Character> ALLOWED_DIGITS = List.of('8', '5', '3');
    private static final List<Integer> EVITERNITY_NUMBERS = generateEviternityNumbers();
    private static final int UPPER_BOUND = 500_000;

    public static int solve(int a, int b) {
        return (int) EVITERNITY_NUMBERS.stream()
                .filter(number -> number >= a && number < b)
                .count();
    }

    private static List<Integer> generateEviternityNumbers() {
        return IntStream.range(1, UPPER_BOUND).filter(EviternitySolver::isEviternity).boxed().toList();
    }

    private static boolean isEviternity(int number) {
        Map<Character, Long> characterCount = String.valueOf(number).chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean onlyContainsAllowedDigits = ALLOWED_DIGITS.containsAll(characterCount.keySet());
        if (!onlyContainsAllowedDigits) {
            return false;
        }
        List<Long> digitValues = ALLOWED_DIGITS.stream()
                .map(digit -> characterCount.getOrDefault(digit, 0L))
                .toList();
        return areDecreasing(digitValues);
    }

    private static boolean areDecreasing(List<Long> counts) {
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > counts.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
