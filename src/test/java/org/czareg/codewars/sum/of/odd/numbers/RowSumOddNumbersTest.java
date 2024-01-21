package org.czareg.codewars.sum.of.odd.numbers;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RowSumOddNumbersTest {

    @Test
    void test1() {
        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
        assertEquals(27, RowSumOddNumbers.rowSumOddNumbers(3));
    }

    @Test
    void randomTests() {
        Random rnd = new Random();
        for (int i = 0; i < 50; i++) {
            int n = rnd.nextInt(500) + 1;
            assertEquals((int) Math.pow(n, 3), RowSumOddNumbers.rowSumOddNumbers(n));
        }
    }
}