package org.czareg.codewars.blowing.birthday.candles;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Suite")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class BlowerTest {

    @Nested
    @Order(1)
    @DisplayName("Fixed Tests")
    class FixedTests {

        @Test
        @Order(1)
        @DisplayName("Basic tests")
        void basicTests() {
            act("1321", 3);
            act("0323456", 9);
            act("2113", 5);
            act("1110", 1);
            act("121", 2);
        }

        @Test
        @Order(2)
        @DisplayName("Edge cases")
        void edgeCases() {
            act("", 0);
            act("000", 0);
            act("0", 0);
            act("0000010001", 2);
            act("00101", 1);
            act("00001001", 2);
            act("102201", 3);
            act("1000", 1);
            act("100100100", 3);
        }

    }

    @Nested
    @Order(2)
    @DisplayName("Random Tests")
    class RandomTests {

        @Test
        @Order(1)
        @DisplayName("1-5 Candles (25 Cakes)")
        void batch1() {
            for (int i = 0; i < 25; i++) {
                String str = randomStr(RANDOM.nextInt(1, 5 + 1));
                int expected = reference(str);
                act(str, expected);
            }
        }

        @Test
        @Order(2)
        @DisplayName("10-20 Candles (25 Cakes)")
        void batch2() {
            for (int i = 0; i < 25; i++) {
                String str = randomStr(RANDOM.nextInt(10, 20 + 1));
                int expected = reference(str);
                act(str, expected);
            }
        }

        @Test
        @Order(3)
        @DisplayName("30-50 Candles (25 Cakes)")
        void batch3() {
            for (int i = 0; i < 25; i++) {
                String str = randomStr(RANDOM.nextInt(30, 50 + 1));
                int expected = reference(str);
                act(str, expected);
            }
        }

        @Test
        @Order(4)
        @DisplayName("60-100 Candles (25 Cakes)")
        void batch4() {
            for (int i = 0; i < 25; i++) {
                String str = randomStr(RANDOM.nextInt(60, 100 + 1));
                int expected = reference(str);
                act(str, expected);
            }
        }

        private static final Random RANDOM = new Random();

        static String randomStr(int length) {
            char[] chrs = new char[length];
            for (int i = 0; i < length; i++) chrs[i] = (char) (RANDOM.nextInt(0, 10) + (int) '0');
            return new String(chrs);
        }

        static int reference(String str) {
            final int w = str.length();
            final int[] q = new int[w];
            for (int i = 0; i < w; i++) q[i] = str.charAt(i) - '0';

            int ptr = 0, cnt = 0;
            while (ptr < w && q[ptr] <= 0) ptr++;

            while (ptr < w) {
                for (int i = 0; i < 3 && ptr + i < w; i++) q[ptr + i]--;
                cnt++;
                while (ptr < w && q[ptr] <= 0) ptr++;
            }

            return cnt;
        }
    }

    static void act(String str, int expected) {
        int actual = Blower.blowCandles(str);
        String msg = String.format("The candles are \"%s\"", str);
        assertEquals(expected, actual, msg);
    }
}