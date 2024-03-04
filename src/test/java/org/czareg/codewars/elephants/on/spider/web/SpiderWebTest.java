package org.czareg.codewars.elephants.on.spider.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiderWebTest {

    @Test
    void testTolerance0() {
        assertEquals(6, new SpiderWeb(10000, 3).getElephantToleranceNumber());
    }

    @Test
    void testTolerance1() {
        assertEquals(9, new SpiderWeb(9200, 12).getElephantToleranceNumber());
    }

    @Test
    void testTolerance2() {
        assertEquals(5, new SpiderWeb(9200, 3).getElephantToleranceNumber());
    }

    @Test
    void testTolerance3() {
        assertEquals(532, new SpiderWeb(532000, 532).getElephantToleranceNumber());
    }

    @Test
    void testTolerance4() {
        assertEquals(15, new SpiderWeb(532000, 5).getElephantToleranceNumber());
    }

    @Test
    void testTolerance5() {
        assertEquals(0, new SpiderWeb(532000, 0).getElephantToleranceNumber());
    }

    @Test
    void testTolerance6() {
        assertEquals(0, new SpiderWeb(532000, -1).getElephantToleranceNumber());
    }

    @Test
    void testTolerance7() {
        assertEquals(0, new SpiderWeb(0, 10).getElephantToleranceNumber());
    }

    @Test
    void testTolerance8() {
        assertEquals(0, new SpiderWeb(-1, 10).getElephantToleranceNumber());
    }

    @Test
    void testTolerance9() {
        assertEquals(55, new SpiderWeb(532000, 10).getElephantToleranceNumber());
    }

    @Test
    void testTolerance10() {
        assertEquals(14, new SpiderWeb(21000, 8).getElephantToleranceNumber());
    }
}