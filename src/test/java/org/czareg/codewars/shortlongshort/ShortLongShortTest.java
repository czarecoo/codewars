package org.czareg.codewars.shortlongshort;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class ShortLongShortTest {

    @DisplayName("Fixed tests")
    @Nested
    @Order(1)
    class FixedTests {

        @Test
        @DisplayName("s1=\"a\", s2=\"bb\"")
        void test_a_bb() {
            ShortLongShortTest.doTest("a", "bb", "abba");
        }

        @Test
        @DisplayName("s1=\"aa\", s2=\"b\"")
        void test_aa_b() {
            ShortLongShortTest.doTest("aa", "b", "baab");
        }

        @Test
        @DisplayName("s1=\"\", s2=\"aa\"")
        void test_empty_aa() {
            ShortLongShortTest.doTest("", "aa", "aa");
        }

        @Test
        @DisplayName("s1=\"bb\", s2=\"\"")
        void test_bb_empty() {
            ShortLongShortTest.doTest("bb", "", "bb");
        }
    }

    @DisplayName("Random tests")
    @Nested
    @Order(2)
    class RandomTests {

        private static final Random RANDOM = new Random();

        @Test
        @DisplayName("Random tests")
        void testRandom() {
            for (String[] testCase : generateCases()) {
                ShortLongShortTest.doTest(testCase[0], testCase[1], testCase[2]);
            }
        }

        private static String generateRandomString(int length) {
            String letters = "abcdefghijklmnopqrstuvwxyz";
            String s = RANDOM.ints(length, 0, letters.length())
                    .mapToObj(i -> String.valueOf(letters.charAt(i)))
                    .collect(Collectors.joining()).toLowerCase();
            return s.substring(0, 1).toUpperCase() + s.toLowerCase();
        }

        private static List<String[]> generateCases() {
            List<String[]> result = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                int lengthA = RANDOM.nextInt(1, 11);
                int lengthB = RANDOM.nextInt(lengthA + 1, lengthA + 10);

                String a = generateRandomString(lengthA);
                String b = generateRandomString(lengthB);

                String combinedString = a + b + a;
                result.add(new String[]{a, b, combinedString});
                result.add(new String[]{b, a, combinedString});
            }

            for (int i = 0; i < 5; i++) {
                int length = RANDOM.nextInt(1, 11);
                String a = generateRandomString(length);

                result.add(new String[]{a, "", a});
                result.add(new String[]{"", a, a});
            }
            Collections.shuffle(result);
            return result;
        }
    }

    public static void doTest(String s1, String s2, String expected) {
        String actual = ShortLongShort.solution(s1, s2);
        String message = String.format(
                "solution(\"%s\", \"%s\") returned wrong answer.%n    Actual: \"%s\"%n  Expected: \"%s\"%n",
                s1, s2, actual, expected
        );
        assertEquals(expected, actual, message);
    }
}