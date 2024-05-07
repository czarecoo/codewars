package org.czareg.codewars.selective.fear.of.numbers;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmophobiaTest {

    @Test
    void monday() {
        doTest("Monday", 13, false);
        doTest("Monday", 12, true);
    }

    @Test
    void tuesday() {
        doTest("Tuesday", 0, false);
        doTest("Tuesday", 100, true);
        doTest("Tuesday", 95, false);
    }

    @Test
    void wednesday() {
        doTest("Wednesday", 35, false);
        doTest("Wednesday", 34, true);
    }

    @Test
    void thursday() {
        doTest("Thursday", 2, false);
        doTest("Thursday", 0, true);
    }

    @Test
    void friday() {
        doTest("Friday", 5, false);
        doTest("Friday", 4, true);
    }

    @Test
    void saturday() {
        doTest("Saturday", 55, false);
        doTest("Saturday", 56, true);
    }

    @Test
    void sunday() {
        doTest("Sunday", 55, false);
        doTest("Sunday", 666, true);
        doTest("Sunday", -666, true);
    }

    @Test
    void randomTests() {
        final String[] weekDays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"};
        final int[] numbers = new int[]{0, 12, 34, 56, 666, -666};
        Random rand = new Random();
        for (int trial = 1; trial <= 100; trial++) {
            String day = weekDays[rand.nextInt(weekDays.length)];
            int num = switch (day) {
                case "Monday", "Wednesday", "Thursday", "Saturday", "Sunday" -> numbers[rand.nextInt(numbers.length)];
                case "Tuesday", "Friday" -> rand.nextInt(190) + 1;
                default -> 0;
            };
            doTest(day, num, solution(day, num));
        }
    }

    private void doTest(final String day, final int num, final boolean expected) {
        assertEquals(expected, Arithmophobia.isAfraid(day, num));
    }

    private boolean solution(final String day, final int num) {
        return switch (day) {
            case "Monday" -> 12 == num;
            case "Tuesday" -> 95 < num;
            case "Wednesday" -> 34 == num;
            case "Thursday" -> 0 == num;
            case "Friday" -> 0 == num % 2;
            case "Saturday" -> 56 == num;
            case "Sunday" -> Math.abs(num) == 666;
            default -> false;
        };
    }
}