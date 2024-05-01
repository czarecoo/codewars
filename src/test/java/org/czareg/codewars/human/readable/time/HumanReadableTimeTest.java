package org.czareg.codewars.human.readable.time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanReadableTimeTest {

    @Test
    void fixedTests() {
        assertEquals("00:00:00", HumanReadableTime.makeReadable(0));
        assertEquals("00:00:59", HumanReadableTime.makeReadable(59));
        assertEquals("00:01:00", HumanReadableTime.makeReadable(60));
        assertEquals("00:01:30", HumanReadableTime.makeReadable(90));
        assertEquals("00:59:59", HumanReadableTime.makeReadable(3599));
        assertEquals("01:00:00", HumanReadableTime.makeReadable(3600));
        assertEquals("12:34:56", HumanReadableTime.makeReadable(45296));
        assertEquals("23:59:59", HumanReadableTime.makeReadable(86399));
        assertEquals("24:00:00", HumanReadableTime.makeReadable(86400));
        assertEquals("99:59:59", HumanReadableTime.makeReadable(359999));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = (int) (Math.random() * 360000);
            assertEquals(solution(randomNumber), HumanReadableTime.makeReadable(randomNumber));
        }
    }

    private static String solution(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }
}