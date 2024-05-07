package org.czareg.codewars.selective.fear.of.numbers;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

/*
I've got a crazy mental illness. I dislike numbers a lot. But it's a little complicated:
The number I'm afraid of depends on which day of the week it is... This is a concrete description of my mental illness:

Monday --> 12
Tuesday --> numbers greater than 95
Wednesday --> 34
Thursday --> 0
Friday --> numbers divisible by 2
Saturday --> 56
Sunday --> 666 or -666

Write a function which takes a string (day of the week) and an integer (number to be tested) so it tells the doctor
if I'm afraid or not. (return a boolean)
 */
@UtilityClass
class Arithmophobia {

    private static final Map<String, Predicate<Integer>> DAYS_BY_ILLNESS_PREDICATE = Map.of(
            "Monday", num -> num == 12,
            "Tuesday", num -> num > 95,
            "Wednesday", num -> num == 34,
            "Thursday", num -> num == 0,
            "Friday", num -> num % 2 == 0,
            "Saturday", num -> num == 56,
            "Sunday", num -> num == 666 || num == -666
    );

    static boolean isAfraid(final String day, final int num) {
        return Optional.ofNullable(DAYS_BY_ILLNESS_PREDICATE.get(day))
                .orElseThrow(() -> new IllegalArgumentException("Unknown day of the week"))
                .test(num);
    }
}
