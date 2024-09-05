package org.czareg.codewars.repeat;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringRepeaterTest {

    @Test
    void test4a() {
        assertEquals("aaaa", StringRepeater.repeatStr(4, "a"));
    }

    @Test
    void test3Hello() {
        assertEquals("HelloHelloHello", StringRepeater.repeatStr(3, "Hello"));
    }

    @Test
    void test5empty() {
        assertEquals("", StringRepeater.repeatStr(5, ""));
    }

    @Test
    void test0a() {
        assertEquals("", StringRepeater.repeatStr(0, "kata"));
    }

    private final char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQERSTUVWXYZ0123456789!@#$%^&*()-=_+[]{}|;:,.<>/?`~".toCharArray();

    @Test
    void testRandom() {
        final Random rand = new Random();
        for (int testIteration = 0; testIteration < 10; ++testIteration) {
            final StringBuilder text = new StringBuilder(rand.nextInt(32));
            for (int i = 0; i < text.capacity(); ++i) {
                final int chi = rand.nextInt(characters.length);
                text.append(characters[chi]);
            }
            final String input = text.toString();
            final int timesToRepeat = rand.nextInt(32);
            final String expected = input.repeat(timesToRepeat);

            assertEquals(expected, StringRepeater.repeatStr(timesToRepeat, input));
        }
    }
}