package org.czareg.codewars.greed.is.good;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreedTest {

    @Test
    void test1() {
        assertEquals(0, Greed.greedy(new int[]{2, 2, 3, 4, 6}));
    }

    @Test
    void test2() {
        assertEquals(100, Greed.greedy(new int[]{1, 2, 3, 4, 6}));
    }

    @Test
    void test3() {
        assertEquals(50, Greed.greedy(new int[]{5, 2, 3, 4, 6}));
    }

    @Test
    void test4() {
        assertEquals(250, Greed.greedy(new int[]{5, 1, 3, 4, 1}));
    }

    @Test
    void test5() {
        assertEquals(1100, Greed.greedy(new int[]{1, 1, 1, 3, 1}));
    }

    @Test
    void test6() {
        assertEquals(450, Greed.greedy(new int[]{2, 4, 4, 5, 4}));
    }

    @Test
    void test7() {
        assertEquals(1150, Greed.greedy(new int[]{1, 1, 1, 5, 1}));
    }

    @Test
    void test8() {
        assertEquals(0, Greed.greedy(new int[]{2, 3, 4, 6, 2}));
    }

    @Test
    void test9() {
        assertEquals(350, Greed.greedy(new int[]{3, 4, 5, 3, 3}));
    }

    @Test
    void test0() {
        assertEquals(250, Greed.greedy(new int[]{1, 5, 1, 2, 4}));
    }

    @Test
    void test10() {
        assertEquals(700, Greed.greedy(new int[]{6, 6, 6, 6, 1}));
    }

    private static final Random RANDOM = new Random();

    @Test
    void testRandomWithTriples() {
        for (int i = 0; i < 50; ++i) {

            int triple = RANDOM.nextInt(6) + 1;
            int single1 = RANDOM.nextInt(6) + 1;
            int single2 = RANDOM.nextInt(6) + 1;

            List<Integer> candidates = Arrays.asList(triple, triple, triple, single1, single2);
            Collections.shuffle(candidates);
            int[] dice = candidates.stream().mapToInt(Integer::valueOf).toArray();

            int expected = triple == 1 ? 1000 : triple * 100;
            expected += single1 == 1 ? 100 : (single1 == 5 ? 50 : 0);
            expected += single2 == 1 ? 100 : (single2 == 5 ? 50 : 0);
            assertEquals(expected, Greed.greedy(dice));
        }
    }

    @Test
    void testRandomNoTriples() {
        List<Integer> candidates = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6);

        for (int i = 0; i < 50; ++i) {
            Collections.shuffle(candidates);
            int[] dice = candidates.subList(0, 5).stream().mapToInt(Integer::valueOf).toArray();
            int expected = 0;

            for (int die : dice) {
                expected += die == 1 ? 100 : (die == 5 ? 50 : 0);
            }
            assertEquals(expected, Greed.greedy(dice));
        }
    }
}