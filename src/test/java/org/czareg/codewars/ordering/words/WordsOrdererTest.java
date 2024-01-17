package org.czareg.codewars.ordering.words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsOrdererTest {

    @Test
    void test1() {
        assertEquals("Thi1s is2 3a T4est", WordsOrderer.order("is2 Thi1s T4est 3a"));
    }

    @Test
    void test2() {
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", WordsOrderer.order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    @Test
    void test3() {
        assertEquals("wha1t sh2all 3we d4o w5ith a6 dru7nken s8ailor", WordsOrderer.order("d4o dru7nken sh2all w5ith s8ailor wha1t 3we a6"));
    }

    @Test
    void test4() {
        assertEquals("", WordsOrderer.order(""));
    }

    @Test
    void test5() {
        assertEquals("1 2 3 4 5 6 7 8 9", WordsOrderer.order("3 6 4 2 8 7 5 1 9"));
    }
}