package org.czareg.codewars.sort.integers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescendingOrderTest {

    @Test
    void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    void test_02() {
        assertEquals(1, DescendingOrder.sortDesc(1));
    }

    @Test
    void test_03() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }

    @Test
    void test_04() {
        assertEquals(2110, DescendingOrder.sortDesc(1021));
    }

    @Test
    void test_05() {
        assertEquals(987654321, DescendingOrder.sortDesc(123495678));
    }
}