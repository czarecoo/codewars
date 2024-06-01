package org.czareg.codewars.persistent.bugger;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistTest {

    @Test
    void basicTests() {
        assertEquals(3, Persist.persistence(39), "Incorrect answer for n=39");
        assertEquals(0, Persist.persistence(4), "Incorrect answer for n=4");
        assertEquals(2, Persist.persistence(25), "Incorrect answer for n=25");
        assertEquals(4, Persist.persistence(999), "Incorrect answer for n=999");
        assertEquals(3, Persist.persistence(444), "Incorrect answer for n=444");
    }

    @Test
    void randomTests() {
        Random rnd = new Random();
        int[] inputs = rnd.ints(100, 1, 500_000).toArray();
        for (int x : inputs) {
            int expected = solution(x);
            assertEquals(expected, Persist.persistence(x), "Incorrect answer for n=%d".formatted(x));
        }
    }

    private static int solution(long n) {
        String[] digits = Long.toString(n).split("");
        if (digits.length == 1) {
            return 0;
        }
        int dprod = 1;
        for (String d : digits) {
            int dgt = Integer.parseInt(d);
            dprod *= dgt;
        }
        return 1 + solution(dprod);
    }
}