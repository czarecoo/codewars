package org.czareg.codewars.atm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AtmTest {

    private int[] my_withdraw(int n) {
        int n100, n50 = 0, n20 = n / 20, r = n % 20;
        if (r == 10) {
            n20 -= 2;
            n50 += 1;
        }
        n100 = n20 / 5;
        n20 %= 5;
        return new int[]{n100, n50, n20};
    }

    @Test
    void allTests() {
        for (int i = 40; i <= 10_000; i += 10) {
            assertEquals(i, my_withdraw(i), Atm.withdraw(i));
        }
    }

    private void assertEquals(int n, int[] solutions, int[] result) {
        String expected = Arrays.toString(solutions);
        String actual = Arrays.toString(result);
        //System.out.printf("%s %s %s%n", n, expected, actual);
        Assertions.assertEquals(expected, actual);
    }
}