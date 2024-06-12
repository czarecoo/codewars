package org.czareg.codewars.sum.of.digits;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalRootTest {

    @Test
    void test1() {
        assertEquals(7, DigitalRoot.digitalRoot(16));
    }

    @Test
    void test2() {
        assertEquals(6, DigitalRoot.digitalRoot(195));
    }

    @Test
    void test3() {
        assertEquals(2, DigitalRoot.digitalRoot(992));
    }

    @Test
    void test4() {
        assertEquals(9, DigitalRoot.digitalRoot(99999999));
    }

    @Test
    void test5() {
        assertEquals(9, DigitalRoot.digitalRoot(167346));
    }

    @Test
    void test6() {
        assertEquals(1, DigitalRoot.digitalRoot(10));
    }

    @Test
    void test7() {
        assertEquals(0, DigitalRoot.digitalRoot(0));
    }

    @Test
    void test8() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(1000000);
            assertEquals(solution(n), DigitalRoot.digitalRoot(n));
        }
    }

    static int solution(int n) {
        return n > 0 ? 1 + (n - 1) % 9 : 0;
    }
}