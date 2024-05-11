package org.czareg.codewars.extended.weekends;

import lombok.experimental.UtilityClass;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/*
If the first day of the month is a Friday, it is likely that the month will have an Extended Weekend. That is, it could have five Fridays, five Saturdays and five Sundays.

In this Kata, you will be given a start year and an end year. Your task will be to find months that have extended weekends and return:

- The first and last month in the range that has an extended weekend
- The number of months that have extended weekends in the range, inclusive of start year and end year.
For example:

solve(2016,2020) = ["JANUARY","MAY","5"]. //The months are: Jan 2016, Jul 2016, Dec 2017, Mar 2019 and May 2020
 */
@UtilityClass
public class ExtendedWeekendFinder {

    public static String[] find(int startYear, int endYear) {
        Deque<YearMonth> extendedWeekends = new LinkedList<>();
        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                YearMonth yearMonth = YearMonth.of(year, month);
                if (yearMonth.atDay(1).getDayOfWeek() == DayOfWeek.FRIDAY && yearMonth.lengthOfMonth() == 31) {
                    extendedWeekends.addLast(yearMonth);
                }
            }
        }
        String firstMonth = getMonthName(extendedWeekends.peekFirst());
        String lastMonth = getMonthName(extendedWeekends.peekLast());
        return new String[]{firstMonth, lastMonth, String.valueOf(extendedWeekends.size())};
    }

    private static String getMonthName(YearMonth yearMonth) {
        return Optional.ofNullable(yearMonth)
                .map(YearMonth::getMonth)
                .map(Enum::name)
                .orElseThrow();
    }
}
