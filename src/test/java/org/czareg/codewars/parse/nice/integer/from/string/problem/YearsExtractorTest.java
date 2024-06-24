package org.czareg.codewars.parse.nice.integer.from.string.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class YearsExtractorTest {

    @Test
    void test1() {
        assertEquals(5, YearsExtractor.howOld("5 years old"));
    }

    @Test
    void test2() {
        assertEquals(9, YearsExtractor.howOld("9 years old"));
    }

    @Test
    void test3() {
        assertEquals(1, YearsExtractor.howOld("1 year old"));
    }

    @Test
    void test4() {
        assertEquals(10001, YearsExtractor.howOld("10001 years old"));
    }

    @Test
    void test5() {
        assertThrows(IllegalArgumentException.class, () -> YearsExtractor.howOld("-5 years old"));
    }

    @Test
    void test6() {
        assertThrows(IllegalArgumentException.class, () -> YearsExtractor.howOld(""));
    }
}