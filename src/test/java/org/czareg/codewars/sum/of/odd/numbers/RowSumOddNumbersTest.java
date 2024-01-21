package org.czareg.codewars.sum.of.odd.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RowSumOddNumbersTest {

    @Test
    void test1() {
        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
        assertEquals(27, RowSumOddNumbers.rowSumOddNumbers(3));
    }
}