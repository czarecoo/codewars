package org.czareg.codewars.extended.weekends;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExtendedWeekendFinderTest {

    private static final Random RANDOM = new Random();

    @Test
    void basicTests() {
        assertArrayEquals(new String[]{"JANUARY", "MAY", "5"}, ExtendedWeekendFinder.find(2016, 2020));
        assertArrayEquals(new String[]{"MARCH", "DECEMBER", "51"}, ExtendedWeekendFinder.find(1900, 1950));
        assertArrayEquals(new String[]{"AUGUST", "OCTOBER", "702"}, ExtendedWeekendFinder.find(1800, 2500));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 200; i++) {
            int a = random(1700, 1900);
            int b = random(1950, 2500);
            assertArrayEquals(solution(a, b), ExtendedWeekendFinder.find(a, b));
        }
    }


    private static String[] solution(int a, int b) {
        int[] monthsWith31Days = new int[]{1, 3, 5, 7, 8, 10, 12};
        String[] result = new String[3];
        int results = 0;
        String lastMonth = "";
        for (int year = a; year <= b; ++year) {
            for (int month : monthsWith31Days) {
                LocalDate localDate = LocalDate.of(year, month, 1);
                DayOfWeek dayOfWeek = localDate.getDayOfWeek();
                String temp = localDate.getMonth().toString();
                if ("FRIDAY".equals(dayOfWeek.toString())) {
                    lastMonth = temp;
                    if (results == 0) {
                        result[0] = temp;
                    }
                    results++;
                }
            }
        }
        result[1] = lastMonth;
        result[2] = String.valueOf(results);
        return result;
    }

    private static int random(int l, int u) {
        return RANDOM.nextInt(u - l) + l;
    }
}