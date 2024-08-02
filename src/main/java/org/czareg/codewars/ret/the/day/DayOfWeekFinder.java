package org.czareg.codewars.ret.the.day;

import lombok.experimental.UtilityClass;

import java.util.Map;

/*
Complete the function which returns the weekday according to the input number:

1 returns "Sunday"
2 returns "Monday"
3 returns "Tuesday"
4 returns "Wednesday"
5 returns "Thursday"
6 returns "Friday"
7 returns "Saturday"
Otherwise returns "Wrong, please enter a number between 1 and 7"
 */
@UtilityClass
public class DayOfWeekFinder {

    private static final Map<Integer, String> DAYS_OF_THE_WEEK = Map.of(
            1, "Sunday",
            2, "Monday",
            3, "Tuesday",
            4, "Wednesday",
            5, "Thursday",
            6, "Friday",
            7, "Saturday"
    );

    public static String getDay(int n) {
        return DAYS_OF_THE_WEEK.getOrDefault(n, "Wrong, please enter a number between 1 and 7");
    }
}
