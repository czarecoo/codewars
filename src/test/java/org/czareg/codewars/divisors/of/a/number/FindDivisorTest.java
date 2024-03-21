package org.czareg.codewars.divisors.of.a.number;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDivisorTest {

    FindDivisor fd = new FindDivisor();

    @Test
    void oneTest() {
        assertEquals(1, fd.numberOfDivisors(1));
    }

    @Test
    void fourTest() {
        assertEquals(3, fd.numberOfDivisors(4));
    }

    @Test
    void fiveTest() {
        assertEquals(2, fd.numberOfDivisors(5));
    }

    @Test
    void twelveTest() {
        assertEquals(6, fd.numberOfDivisors(12));
    }

    @Test
    void thirtyTest() {
        assertEquals(8, fd.numberOfDivisors(30));
    }

    @Test
    void randomTest() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int generated = rand.nextInt(500000) + 1;
            assertEquals(solution(generated), fd.numberOfDivisors(generated));
        }
    }

    private static int solution(int n) {
        int numDiv = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                numDiv++;
            }
        }
        return numDiv;
    }
}