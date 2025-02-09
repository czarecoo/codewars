package org.czareg.codewars.grade.book;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/*
Complete the function so that it finds the average of the three scores passed to it and returns the letter value associated with that grade.

Numerical Score	Letter Grade
90 <= score <= 100	'A'
80 <= score < 90	'B'
70 <= score < 80	'C'
60 <= score < 70	'D'
0 <= score < 60	'F'
Tested values are all between 0 and 100. Theres is no need to check for negative values or values greater than 100.
 */
@UtilityClass
class Grader {

    private static final Map<Character, Predicate<Double>> GRADES = Map.of(
            'A', i -> i >= 90,
            'B', i -> i >= 80 && i < 90,
            'C', i -> i >= 70 && i < 80,
            'D', i -> i >= 60 && i < 70,
            'F', i -> i < 60
    );

    static char getGrade(int s1, int s2, int s3) {
        double average = IntStream.of(s1, s2, s3)
                .average()
                .orElseThrow();
        return GRADES.entrySet()
                .stream()
                .filter(entry -> entry.getValue().test(average))
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow();
    }
}
