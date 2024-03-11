package org.czareg.codewars.unlucky.days;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlackFridayCalculatorTest {

    @Test
    void fixedTests() {
        assertEqualsWithMsg("Year: 1618", 2, BlackFridayCalculator.unluckyDays(1618));
        assertEqualsWithMsg("Year: 1812", 2, BlackFridayCalculator.unluckyDays(1812));
        assertEqualsWithMsg("Year: 1909", 1, BlackFridayCalculator.unluckyDays(1909));
        assertEqualsWithMsg("Year: 2065", 3, BlackFridayCalculator.unluckyDays(2065));
        assertEqualsWithMsg("Year: 2132", 1, BlackFridayCalculator.unluckyDays(2132));
        assertEqualsWithMsg("Year: 2723", 2, BlackFridayCalculator.unluckyDays(2723));
        assertEqualsWithMsg("Year: 2792", 2, BlackFridayCalculator.unluckyDays(2792));
        assertEqualsWithMsg("Year: 2819", 2, BlackFridayCalculator.unluckyDays(2819));
    }

    private static boolean isFriday(LocalDate ld) {
        return ld.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    private static int reference(int year) {
        LocalDate ld = LocalDate.of(year, 1, 13);
        int result = isFriday(ld) ? 1 : 0;
        for (int i = 1; i < 12; i++) {
            if (isFriday(ld.plusMonths(i))) {
                result += 1;
            }
        }
        return result;
    }

    @Test
    void randomTests() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int randomYear = 1593 + rnd.nextInt(10000 - 1593);
            assertEqualsWithMsg("Year: " + randomYear, reference(randomYear), BlackFridayCalculator.unluckyDays(randomYear));
        }
    }

    private static void assertEqualsWithMsg(String msg, int expected, int actual) {
        assertEquals(expected, actual, msg);
    }
}