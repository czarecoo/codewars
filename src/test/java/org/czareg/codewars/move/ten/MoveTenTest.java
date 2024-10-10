package org.czareg.codewars.move.ten;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveTenTest {

    @Test
    void sampleTests() {
        assertEquals("docdmkco", MoveTen.moveTen("testcase"));
        assertEquals("mynogkbc", MoveTen.moveTen("codewars"));
        assertEquals("ohkwzvodocdrobo", MoveTen.moveTen("exampletesthere"));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            String randomString = randomString(rand.nextInt(20) + 1);
            assertEquals(solution(randomString), MoveTen.moveTen(randomString));
        }
    }

    private String randomString(int length) {
        return rand.ints(length, 'a', 'z' + 1)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private String solution(String s) {
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += 10;
            chars[i] = chars[i] > 'z' ? (char) (chars[i] % 'z' + 'a' - 1) : chars[i];
        }
        return new String(chars);
    }

    private final Random rand = new Random();
}