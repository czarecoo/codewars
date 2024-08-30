package org.czareg.codewars.vector.affinity;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AffinityCalculatorTest {

    private static final double EPSILON = 1e-6;

    @Test
    @Order(1)
    void sampleTests() {
        assertEquals(3.0 / 5.0, AffinityCalculator.vectorAffinity(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 2, 4, 3}), EPSILON, "vectorAffinity([1,2,3,4,5],[1,2,2,4,3])");
        assertEquals(1.0, AffinityCalculator.vectorAffinity(new int[]{1, 2, 3}, new int[]{1, 2, 3}), EPSILON, "vectorAffinity([1,2,3],[1,2,3])");
        assertEquals(3.0 / 5.0, AffinityCalculator.vectorAffinity(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5}), EPSILON, "vectorAffinity([1,2,3],[1,2,3,4,5])");
        assertEquals(3.0 / 4.0, AffinityCalculator.vectorAffinity(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 5}), EPSILON, "vectorAffinity([1,2,3,4],[1,2,3,5])");
        assertEquals(1.0 / 6.0, AffinityCalculator.vectorAffinity(new int[]{6, 6, 6, 6, 6, 6}, new int[]{6}), EPSILON, "vectorAffinity([6,6,6,6,6,6],[6])");
        assertEquals(1.0, AffinityCalculator.vectorAffinity(new int[]{}, new int[]{}), EPSILON, "vectorAffinity([],[])");
        assertEquals(0.0, AffinityCalculator.vectorAffinity(new int[]{6}, new int[]{}), EPSILON);
        assertEquals(0.0, AffinityCalculator.vectorAffinity(new int[]{}, new int[]{34}), EPSILON);
    }

    @Test
    @Order(2)
    void randomTests() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            int[] xs = rnd.ints(rnd.nextInt(0, 200), 0, 2000000).toArray();
            int[] ys = rnd.ints(rnd.nextInt(0, 200), 0, 2000000).toArray();
            for (int x = 0; x < Math.min(xs.length, ys.length); x++) {
                if (rnd.nextBoolean()) xs[x] = ys[x];
            }
            assertEquals(solution(xs, ys), AffinityCalculator.vectorAffinity(xs.clone(), ys.clone()), EPSILON, "vectorAffinity(" + Arrays.toString(xs) + "," + Arrays.toString(ys) + ")");
        }
    }

    private static double solution(int[] xs, int[] ys) {
        double max = Math.max(xs.length, ys.length);
        double min = Math.min(xs.length, ys.length);
        if (max == 0.0) return 1.0;
        double count = 0.0;
        for (int i = 0; i < min; i++) {
            if (xs[i] == ys[i]) {
                count++;
            }
        }
        return count / max;
    }
}