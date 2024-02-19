package org.czareg.codewars.fizz.buzz.cuckoo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzCuckooClockTest {

    @Test
    void basicTests() {
        assertEquals("tick", FizzBuzzCuckooClock.fizzBuzzCuckooClock("13:34"));
        assertEquals("Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo", FizzBuzzCuckooClock.fizzBuzzCuckooClock("21:00"));
        assertEquals("Fizz Buzz", FizzBuzzCuckooClock.fizzBuzzCuckooClock("11:15"));
        assertEquals("Fizz", FizzBuzzCuckooClock.fizzBuzzCuckooClock("03:03"));
        assertEquals("Cuckoo", FizzBuzzCuckooClock.fizzBuzzCuckooClock("14:30"));
        assertEquals("Buzz", FizzBuzzCuckooClock.fizzBuzzCuckooClock("08:55"));
        assertEquals("Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo", FizzBuzzCuckooClock.fizzBuzzCuckooClock("00:00"));
        assertEquals("Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo", FizzBuzzCuckooClock.fizzBuzzCuckooClock("12:00"));
    }

    public static String myFizzBuzzCuckooClock(String time) {
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        if (minutes == 0) {
            String[] cuckoos = new String[hours % 12 == 0 ? 12 : hours % 12];
            Arrays.fill(cuckoos, "Cuckoo");
            return String.join(" ", cuckoos);
        } else if (minutes == 15 || minutes == 45) {
            return "Fizz Buzz";
        } else if (minutes == 30) {
            return "Cuckoo";
        }
        return minutes % 3 == 0 ? "Fizz" : minutes % 5 == 0 ? "Buzz" : "tick";
    }

    @Test
    void randomTests() {
        String actual;
        String expected;
        Random rand = new Random();
        // first, I want to be sure that 0, 15, 30, and 45 do get included regardless
        // of whatever other completely random numbers come up in subsequent tests
        String[] quarters = new String[]{":00", ":15", ":30", ":45"};
        for (String quarter : quarters) {
            int hour = rand.nextInt(24);
            String quarterTime = (hour < 10 ? "0" + hour : Integer.toString(hour)) + quarter;
            actual = FizzBuzzCuckooClock.fizzBuzzCuckooClock(quarterTime);
            expected = myFizzBuzzCuckooClock(quarterTime);
            assertEquals(expected, actual);
        }

        // and some totally-random tests
        for (int i = 0; i < 40; i++) {
            int hour = rand.nextInt(24);
            int minute = rand.nextInt(60);
            String time = (hour < 10 ? "0" + hour : Integer.toString(hour)) + ":" + (minute < 10 ? "0" + minute : Integer.toString(minute));
            actual = FizzBuzzCuckooClock.fizzBuzzCuckooClock(time);
            expected = myFizzBuzzCuckooClock(time);
            assertEquals(expected, actual);
        }
    }
}