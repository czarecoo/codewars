package org.czareg.codewars.exclamation.marks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExclamationMarksTest {

    @Test
    void basicTests() {
        assertEquals("H!!", ExclamationMarks.replace("Hi!"));
        assertEquals("!H!! H!!", ExclamationMarks.replace("!Hi! Hi!"));
        assertEquals("!!!!!", ExclamationMarks.replace("aeiou"));
        assertEquals("!BCD!", ExclamationMarks.replace("ABCDE"));
    }

    @Test
    void randomTests() {
        for (int trial = 0; trial < 100; trial++) {
            String s = randomString();
            assertEquals(solution(s), ExclamationMarks.replace(s));
        }
    }

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private boolean randomBool() {
        return randomInt(1, 1000) % 2 == 0;
    }

    private char randomLower() {
        return alphabet[randomInt(0, 25)];
    }

    private char randomUpper() {
        return Character.toUpperCase(randomLower());
    }

    private String randomWord() {
        char[] s = new char[randomInt(3, 7)];
        for (int i = 0; i < s.length; i++) s[i] = randomBool() ? randomLower() : randomUpper();
        return new String(s);
    }

    private String randomString() {
        int wordCount = randomInt(1, 8);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            if (randomInt(0, 6) == 6) sb.append('!');
            sb.append(randomWord());
            if (randomInt(0, 6) == 6) sb.append('!');
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static final String vowels = "aeiouAEIOU";

    private String solution(final String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) if (vowels.indexOf(sb.charAt(i)) >= 0) sb.setCharAt(i, '!');
        return sb.toString();
    }
}