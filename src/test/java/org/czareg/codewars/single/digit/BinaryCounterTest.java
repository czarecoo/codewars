package org.czareg.codewars.single.digit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryCounterTest {

    @Test
    void fixed() {
        assertEquals(5, BinaryCounter.singleDigit(5665));
        assertEquals(5, BinaryCounter.singleDigit(5));
        assertEquals(8, BinaryCounter.singleDigit(999));
        assertEquals(1, BinaryCounter.singleDigit(1234444123));
        assertEquals(2, BinaryCounter.singleDigit(443566));
        assertEquals(3, BinaryCounter.singleDigit(565656565));
        assertEquals(8, BinaryCounter.singleDigit(4868872));
        assertEquals(2, BinaryCounter.singleDigit(234234235));
        assertEquals(7, BinaryCounter.singleDigit(567448));
        assertEquals(3, BinaryCounter.singleDigit(1000000000));
    }

    private static int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }

    private static int solution(int n) {
        return (n < 10) ? n : solution(Integer.toBinaryString(n).replace("0", "").length());
    }

    @Test
    void random() {
        int randNum = getRandomInt(1, 1000000000);
        int actual = BinaryCounter.singleDigit(randNum);
        int expected = solution(randNum);
        assertEquals(expected, actual, String.format("given: %s", randNum));
    }
}