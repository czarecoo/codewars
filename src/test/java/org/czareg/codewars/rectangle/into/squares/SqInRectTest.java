package org.czareg.codewars.rectangle.into.squares;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SqInRectTest {

    @Test
    void test1() {
        assertResult(Arrays.asList(3, 2, 1, 1), SqInRect.sqInRect(5, 3));
    }

    @Test
    void test2() {
        assertResult(emptyList(), SqInRect.sqInRect(5, 5));
    }

    @Test
    void test3() {
        assertResult(Arrays.asList(3, 2, 1, 1), SqInRect.sqInRect(3, 5));
    }

    @Test
    void test4() {
        assertResult(Arrays.asList(14, 6, 6, 2, 2, 2), SqInRect.sqInRect(20, 14));
    }

    @Test
    void test5() {
        assertResult(Arrays.asList(14, 6, 6, 2, 2, 2), SqInRect.sqInRect(14, 20));
    }

    @Test
    void test6() {
        assertResult(Arrays.asList(32, 32, 32, 32, 32, 32, 32, 16, 16), SqInRect.sqInRect(240, 32));
    }

    @Test
    void test7() {
        assertResult(Arrays.asList(230, 230, 165, 65, 65, 35, 30, 5, 5, 5, 5, 5, 5), SqInRect.sqInRect(625, 230));
    }

    @Test
    void test8() {
        assertResult(Arrays.asList(230, 230, 230, 41, 41, 41, 41, 41, 25, 16, 9, 7, 2, 2, 2, 1, 1), SqInRect.sqInRect(731, 230));
    }

    @Test
    void test9() {
        assertResult(Arrays.asList(14, 14, 9, 5, 4, 1, 1, 1, 1), SqInRect.sqInRect(37, 14));
    }

    @Test
    void test10() {
        assertResult(Arrays.asList(1, 1), SqInRect.sqInRect(2, 1));
    }

    public static List<Integer> sqInRectTest(int lng, int wdth) {
        if (lng == wdth) return null;
        if (lng < wdth) {
            int tmp = lng;
            lng = wdth;
            wdth = tmp;
        }
        List<Integer> res = new ArrayList<>();
        while (lng != wdth) {
            res.add(wdth);
            lng -= wdth;
            if (lng < wdth) {
                int tmp = lng;
                lng = wdth;
                wdth = tmp;
            }
        }
        res.add(wdth);
        return res;
    }

    @Test
    void test() {
        Random rnd = new Random();
        List<Integer> someLengths = new ArrayList<>(Arrays.asList(
                55, 89, 144, 233, 377, 610, 987, 1597, 2584, 418,
                676, 41, 99, 56, 78, 907, 561, 453, 32, 12,
                24, 13, 59, 90, 21, 66, 77, 88, 62, 11));
        List<Integer> someWidths = new ArrayList<>(Arrays.asList(
                22, 75, 121, 340, 52, 78, 157, 88, 55, 102,
                120, 73, 37, 44, 565, 1002, 43, 90, 72, 10,
                24, 13, 59, 32, 34, 51, 12, 68, 34, 100));
        for (int i = 0; i < 10; i++) {
            int rn = rnd.nextInt(29);
            int f1 = someLengths.get(rn);
            int f2 = someWidths.get(rn);
            assertResult(SqInRectTest.sqInRectTest(f1, f2), SqInRect.sqInRect(f1, f2));
        }
    }

    private void assertResult(List<Integer> expected, List<Integer> actual) {
        if (expected == null || expected.isEmpty()) {
            assertTrue(actual == null || actual.isEmpty());
        } else {
            assertEquals(expected, actual);
        }
    }
}