package org.czareg.codewars.ret.the.day;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeekFinderFinderTest {

    @Test
    void testSomething() {
        assertEquals("Sunday", DayOfWeekFinder.getDay(1));
        assertEquals("Monday", DayOfWeekFinder.getDay(2));
        assertEquals("Tuesday", DayOfWeekFinder.getDay(3));
        assertEquals("Wednesday", DayOfWeekFinder.getDay(4));
        assertEquals("Thursday", DayOfWeekFinder.getDay(5));
        assertEquals("Friday", DayOfWeekFinder.getDay(6));
        assertEquals("Saturday", DayOfWeekFinder.getDay(7));
        assertEquals("Wrong, please enter a number between 1 and 7", DayOfWeekFinder.getDay(0));
        assertEquals("Wrong, please enter a number between 1 and 7", DayOfWeekFinder.getDay(8));
        assertEquals("Wrong, please enter a number between 1 and 7", DayOfWeekFinder.getDay(20));
    }


    @Test
    void testSomethingRandom() {
        for (int i = 0; i < 100; i++) {
            int r = (int) (Math.random() * 15);

            String day = solution(r);

            assertEquals(day, DayOfWeekFinder.getDay(r));
        }
    }

    private String solution(int n) {
        return switch (n) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Wrong, please enter a number between 1 and 7";
        };
    }
}