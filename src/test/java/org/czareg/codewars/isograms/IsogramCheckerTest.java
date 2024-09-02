package org.czareg.codewars.isograms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IsogramCheckerTest {

    static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Test
    void fixedTests() {
        assertTrue(IsogramChecker.isIsogram("Dermatoglyphics"));
        assertTrue(IsogramChecker.isIsogram("isogram"));
        assertFalse(IsogramChecker.isIsogram("moose"));
        assertFalse(IsogramChecker.isIsogram("isIsogram"));
        assertFalse(IsogramChecker.isIsogram("aba"));
        assertFalse(IsogramChecker.isIsogram("moOse"));
        assertTrue(IsogramChecker.isIsogram("thumbscrewjapingly"));
        assertTrue(IsogramChecker.isIsogram(""));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 101; ) {
            String input = randomString(++i * 10);
            assertEquals(solution(input), IsogramChecker.isIsogram(input));
        }
    }

    public String randomString(int len) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            stringBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return stringBuilder.toString();
    }

    private static boolean solution(String input) {
        input = input.toLowerCase();
        int len = input.length();
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
