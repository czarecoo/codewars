package org.czareg.codewars.remove.duplicates.from.list;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DuplicatesRemoverTest {

    @Test
    @Order(0)
    @DisplayName("Empty array")
    void emptyArray() {
        test(new int[0], new int[0]);
    }

    @Test
    @Order(1)
    @DisplayName("Array of one element")
    void oneElement() {
        test(new int[]{1}, new int[]{1});
    }

    @Test
    @Order(2)
    @DisplayName("Array of distinct elements")
    void distinctElements() {
        test(new int[]{1, 2}, new int[]{1, 2});
    }

    @Test
    @Order(3)
    @DisplayName("Basic test case 1")
    void testBasicOne() {
        test(new int[]{1, 2}, new int[]{1, 1, 2});
    }

    @Test
    @Order(4)
    @DisplayName("Basic test case 2")
    void testBasicTwo() {
        test(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 2, 3, 4, 5});
    }

    @Test
    @Order(5)
    @DisplayName("Basic test case 3")
    void testBasicThree() {
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 2, 2, 1, 3, 3, 1, 4, 2, 4, 5, 6, 7, 7, 7});
    }

    @Test
    @Order(6)
    @DisplayName("Random test cases")
    void rndTest() {
        for (int i = 0; i < 100; i++) {
            int[] testCase = generateTestCase();
            int[] expected = trueDistinct(testCase);
            test(expected, testCase);
        }
    }

    private void test(int[] expected, int[] input) {
        int[] actual = DuplicatesRemover.distinct(input.clone());
        String msg = "For input: " + (input.length < 100 ? Arrays.toString(input) : "[(" + input.length + " elements)]")
                     + "\nexpected:  " + Arrays.toString(expected)
                     + "\nactual:    " + Arrays.toString(actual) + "\n";
        assertArrayEquals(expected, actual, msg);
    }

    private int[] generateTestCase() {
        var rnd = ThreadLocalRandom.current();
        return rnd.ints(rnd.nextLong(1L << rnd.nextLong(19)), 0, 100)
                .toArray();
    }

    private int[] trueDistinct(int[] testCase) {
        Set<Integer> uniques = new LinkedHashSet<>();
        Arrays.stream(testCase).forEach(uniques::add);
        return uniques.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}