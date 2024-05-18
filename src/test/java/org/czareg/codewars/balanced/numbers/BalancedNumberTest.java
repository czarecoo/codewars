package org.czareg.codewars.balanced.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalancedNumberTest {

    @Test
    void check_Balanced_Number() {
        assertEquals("Balanced", BalancedNumber.balancedNum(7));
        assertEquals("Balanced", BalancedNumber.balancedNum(959));
        assertEquals("Balanced", BalancedNumber.balancedNum(13));
        assertEquals("Not Balanced", BalancedNumber.balancedNum(432));
        assertEquals("Balanced", BalancedNumber.balancedNum(424));
    }

    @Test
    void check_Larger_Number() {
        assertEquals("Not Balanced", BalancedNumber.balancedNum(1024));
        assertEquals("Not Balanced", BalancedNumber.balancedNum(66545));
        assertEquals("Not Balanced", BalancedNumber.balancedNum(295591));
        assertEquals("Not Balanced", BalancedNumber.balancedNum(1230987));
        assertEquals("Balanced", BalancedNumber.balancedNum(56239814));
    }

    private String solution(long number) {
        char[] a = String.valueOf(number).toCharArray();
        int sum = 0;
        for (int i = 0; i < a.length / 2 - (a.length % 2 == 0 ? 1 : 0); i++) {
            sum += Character.digit(a[i], 10);
            sum -= Character.digit(a[a.length - i - 1], 10);
        }
        return sum == 0 ? "Balanced" : "Not Balanced";
    }

    @Test
    void random_Tests() {
        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 99999999 + 1);
            assertEquals(solution(n), BalancedNumber.balancedNum(n));
        }
    }
}