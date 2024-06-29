package org.czareg.codewars.fake.binary;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeBinaryTest {

    @Test
    void testSomething() {
        assertEquals("01011110001100111", FakeBinary.fakeBin("45385593107843568"));
        assertEquals("101000111101101", FakeBinary.fakeBin("509321967506747"));
        assertEquals("011011110000101010000011011", FakeBinary.fakeBin("366058562030849490134388085"));
    }

    @Test
    void randomTests() {
        String chars = "0123456789";
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            String s = IntStream.range(0, random.nextInt(100) + 1)
                    .mapToObj(unused -> Character.toString(chars.charAt(random.nextInt(chars.length()))))
                    .collect(Collectors.joining());
            String solution = solution(s);
            assertEquals(solution, FakeBinary.fakeBin(s));
        }
    }

    private static String solution(String s) {
        return s.replaceAll("[1-4]", "0").replaceAll("[5-9]", "1");
    }
}