package org.czareg.codewars.letters.best.friend;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {

    @Test
    void basicTestCases() {
        assertTrue(
                Letter.bestFriend("he headed to the store", 'h', 'e'),
                "for input: \"he headed to the store\", 'h', 'e'"
        );
        assertTrue(
                Letter.bestFriend("i found an ounce with my hound", 'o', 'u'),
                "for input: \"i found an ounce with my hound\", 'o', 'u'"
        );
        assertTrue(
                Letter.bestFriend("those were their thorns they said", 't', 'h'),
                "for input: \"those were their thorns they said\", 't', 'h'"
        );
        assertFalse(
                Letter.bestFriend("we found your dynamite", 'd', 'y'),
                "for input: \"we found your dynamite\", 'd', 'y'"
        );
        assertFalse(
                Letter.bestFriend("look they took the cookies", 'o', 'o'),
                "for input: \"look they took the cookies\", 'o', 'o'"
        );
        assertFalse(Letter.bestFriend("a test", 't', 'e'), "for input: \"a test\", 't', 'e'");
        assertFalse(Letter.bestFriend("abcdee", 'e', 'e'), "for input: \"abcdee\", 'e', 'e'");
        assertFalse(Letter.bestFriend("abcde", 'e', 'e'), "for input: \"abcde\", 'e', 'e'");
        assertTrue(Letter.bestFriend("xaeaex", 'a', 'e'), "for input: \"xaeaex\", 'a', 'e'");
        assertTrue(Letter.bestFriend("", 'x', 'y'), "for input: \"\", 'x', 'y'");
    }

    private static final Random RANDOM = new Random();

    @RepeatedTest(200)
    void testRandomStringsProbablyFalse() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        char before = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        char after = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        String randomString = generateRandomString(RANDOM.nextInt(5, 200), alphabet);
        assertEquals(
                referenceSolution(randomString, before, after),
                Letter.bestFriend(randomString, before, after),
                "for input: \"" + randomString + "\", '" + before + "', '" + after + "'"
        );
    }

    @RepeatedTest(200)
    void testRandomStringsProbablyTrue() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        char before = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        char after = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        String randomString = generateRandomString(RANDOM.nextInt(100, 200), alphabet, before, after);
        assertEquals(
                referenceSolution(randomString, before, after),
                Letter.bestFriend(randomString, before, after),
                "for input: \"" + randomString + "\", '" + before + "', '" + after + "'"
        );
    }

    @RepeatedTest(50)
    void testRandomStringsVacuousTruth() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        int beforeIdx = RANDOM.nextInt(alphabet.length());
        char before = alphabet.charAt(beforeIdx);
        char after = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        String randomString = generateRandomString(
                RANDOM.nextInt(100, 200),
                alphabet.substring(0, beforeIdx) + alphabet.substring(beforeIdx + 1)
        );
        assertEquals(
                referenceSolution(randomString, before, after),
                Letter.bestFriend(randomString, before, after),
                "for input: \"" + randomString + "\", '" + before + "', '" + after + "'"
        );
    }

    @RepeatedTest(20)
    void testRandomStringsEndCondition() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        char before = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        char after = alphabet.charAt(RANDOM.nextInt(alphabet.length()));
        String randomString = generateRandomString(RANDOM.nextInt(99, 199), alphabet, before, after) + before;
        assertEquals(
                referenceSolution(randomString, before, after),
                Letter.bestFriend(randomString, before, after),
                "for input: \"" + randomString + "\", '" + before + "', '" + after + "'"
        );
    }

    @RepeatedTest(20)
    void testRandomStringsVacuousTruth2() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        int beforeIdx = RANDOM.nextInt(alphabet.length());
        char before = alphabet.charAt(beforeIdx);
        String randomString = generateRandomString(
                RANDOM.nextInt(100, 200),
                alphabet.substring(0, beforeIdx) + alphabet.substring(beforeIdx + 1)
        );
        assertEquals(
                referenceSolution(randomString, before, before),
                Letter.bestFriend(randomString, before, before),
                "for input: \"" + randomString + "\", '" + before + "', '" + before + "'"
        );
    }

    private static String generateRandomString(int length, String alphabet) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(alphabet.length());
            builder.append(alphabet.charAt(randomIndex));
        }

        return builder.toString();
    }

    private static String generateRandomString(int length, String alphabet, char first, char second) {
        StringBuilder builder = new StringBuilder();
        char last = second;
        for (int i = 0; i < length; i++) {
            if (last == first) {
                builder.append(second);
                last = second;
                continue;
            }
            int randomIndex = RANDOM.nextInt(alphabet.length());
            last = alphabet.charAt(randomIndex);
            builder.append(last);
        }
        return builder.toString();
    }

    private static boolean referenceSolution(String txt, char a, char b) {
        return !Pattern.compile(a + "(?:$|[^" + b + "])").asPredicate().test(txt);
    }
}