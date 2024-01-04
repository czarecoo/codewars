package org.czareg.codewars.adding.big.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigNumberAdderTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(textBlock = """
                1   , 1  ,    2
                123 , 456,    579
                888 , 222,    1110
                1372, 69 ,    1441
                12  , 456,    468
                100 , 101,    201
                63829983432984289347293874, 90938498237058927340892374089, 91002328220491911630239667963
            """)
    void basicTests(String a, String b, String expected) {
        assertEquals(expected, BigNumberAdder.add(a, b));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 50; i++) {
            String s = randomNums();
            String s2 = randomNums();
            assertEquals(solve(s, s2), BigNumberAdder.add(s, s2), String.format("%s + %s", s, s2));
        }
    }

    private String solve(String s, String s2) {
        String result = "";
        s2 = "0".repeat(s.length() < s2.length() ? 0 : s.length() - s2.length()) + s2;
        s = "0".repeat(s2.length() < s.length() ? 0 : s2.length() - s.length()) + s;
        int remainder = 0;
        for (long i = s.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(s.charAt((int) i) + "");
            n += Integer.parseInt(s2.charAt((int) i) + "");
            n += remainder;
            remainder = n / 10;
            result = n % 10 + result;
        }
        result = remainder == 0 ? result : remainder + result;
        while (result.startsWith("0")) {
            result = result.substring(1);
        }
        return result;
    }

    private String randomNums() {
        Random r = ThreadLocalRandom.current();
        int l = r.nextInt(30) + 3;
        StringBuilder s = new StringBuilder();
        boolean allZeros = true;
        for (int i = 0; i < l; i++) {
            int digit = r.nextInt(10);
            allZeros &= digit == 0;
            s.append(digit);
        }
        return allZeros ? "1" : s.toString();
    }
}