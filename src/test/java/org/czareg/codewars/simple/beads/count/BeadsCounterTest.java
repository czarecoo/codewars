package org.czareg.codewars.simple.beads.count;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeadsCounterTest {

    @Test
    void test0() {
        assertEquals(0, BeadsCounter.countRedBeads(0));
    }

    @Test
    void test1() {
        assertEquals(0, BeadsCounter.countRedBeads(1));
    }

    @Test
    void test3() {
        assertEquals(4, BeadsCounter.countRedBeads(3));
    }

    @Test
    void test5() {
        assertEquals(8, BeadsCounter.countRedBeads(5));
    }

    @Test
    void randomtests() {
        IntStream.range(0, 100).forEachOrdered(n -> {
            int b = (int) (Math.random() * 5000 * n);
            assertEquals(solution(b), BeadsCounter.countRedBeads(b));
        });
    }

    private int solution(final int nBlue) {
        return Math.max(2 * nBlue - 2, 0);
    }
}