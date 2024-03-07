package org.czareg.codewars.product.of.consecutive.fib.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdFibTest {

    @Test
    void test1() {
        long[] r = new long[]{55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }

    @Test
    void test2() {
        long[] r = new long[]{89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }

    @Test
    void test3() {
        long[] r = new long[]{6765, 10946, 1};
        assertArrayEquals(r, ProdFib.productFib(74049690));
    }

    @Test
    void test4() {
        long[] r = new long[]{10946, 17711, 0};
        assertArrayEquals(r, ProdFib.productFib(84049690));
    }

    @Test
    void test5() {
        long[] r = new long[]{10946, 17711, 1};
        assertArrayEquals(r, ProdFib.productFib(193864606));
    }

    @Test
    void test6() {
        long[] r = new long[]{610, 987, 0};
        assertArrayEquals(r, ProdFib.productFib(447577));
    }

    @Test
    void test7() {
        long[] r = new long[]{610, 987, 1};
        assertArrayEquals(r, ProdFib.productFib(602070));
    }

    @Test
    void test8() {
        long[] r = new long[]{832040, 1346269, 0};
        assertArrayEquals(r, ProdFib.productFib(602070602070L));
    }

    @Test
    void test9() {
        long[] r = new long[]{832040, 1346269, 1};
        assertArrayEquals(r, ProdFib.productFib(1120149658760L));
    }

    @Test
    void test10() {
        long[] r = new long[]{1346269, 2178309, 1};
        assertArrayEquals(r, ProdFib.productFib(2932589879121L));
    }

    @Test
    void test11() {
        long[] r = new long[]{1, 1, 1};
        assertArrayEquals(r, ProdFib.productFib(1));
    }

    @Test
    void test12() {
        long[] r = new long[]{1836311903L, 2971215073L, 0};
        assertArrayEquals(r, ProdFib.productFib(4456077604922913920L));
    }

    @Test
    void test() {
        Random rnd = new Random();
        long[] someFibs = {55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
                10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229,
                832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352,
                24157817, 39088169, 63245986};

        for (int k = 0; k < 15; k++) {
            int rn = rnd.nextInt(someFibs.length - 1);
            long f1 = someFibs[rn];
            long f2 = someFibs[rn + 1];
            long p = f1 * f2;
            long[] r = new long[]{f1, f2, 1L};
            assertArrayEquals(r, ProdFib.productFib(p));
        }
    }

    private static void assertArrayEquals(long[] expected, long[] actual) {
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}