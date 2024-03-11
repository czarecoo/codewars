package org.czareg.codewars.unlucky.days;

import lombok.experimental.UtilityClass;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

/*
Friday 13th or Black Friday is considered as unlucky day. Calculate how many unlucky days are in the given year.

Find the number of Friday 13th in the given year.

Input: Year in Gregorian calendar as integer.

Output: Number of Black Fridays in the year as an integer.

Examples:

unluckyDays(2015) == 3
unluckyDays(1986) == 1
 */
@UtilityClass
public class BlackFridayCalculator {

    private static final int BLACK_FRIDAY_DAY = 13;

    public static int unluckyDays(int year) {
        return (int) Arrays.stream(Month.values())
                .map(Month::getValue)
                .map(month -> LocalDate.of(year, month, BLACK_FRIDAY_DAY))
                .map(LocalDate::getDayOfWeek)
                .filter(DayOfWeek.FRIDAY::equals)
                .count();
    }
}
