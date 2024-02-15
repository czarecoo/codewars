package org.czareg.codewars.remove.the.min;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoverTest {

    @Test
    void test1() {
        int[] actual = Remover.removeSmallest(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{2, 3, 4, 5}, actual,
                "For numbers = [1, 2, 3, 4, 5]:\nexpected: [2, 3, 4, 5]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test2() {
        int[] actual = Remover.removeSmallest(new int[]{5, 3, 2, 1, 4});
        assertArrayEquals(new int[]{5, 3, 2, 4}, actual,
                "For numbers = [5, 3, 2, 1, 4]:\nexpected: [5, 3, 2, 4]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test3() {
        int[] actual = Remover.removeSmallest(new int[]{2, 2, 1, 2, 1});
        assertArrayEquals(new int[]{2, 2, 2, 1}, actual,
                "For numbers = [2, 2, 1, 2, 1]:\nexpected: [2, 2, 2, 1]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test4() {
        int[] actual = Remover.removeSmallest(new int[]{5, 3, 2, 1, 4});
        assertArrayEquals(new int[]{5, 3, 2, 4}, actual,
                "For numbers = [5, 3, 2, 1, 4]:\nexpected: [5, 3, 2, 4]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test5() {
        int[] actual = Remover.removeSmallest(new int[]{5, 4, 3, 2, 1});
        assertArrayEquals(new int[]{5, 4, 3, 2}, actual,
                "For numbers = [5, 4, 3, 2, 1]:\nexpected: [5, 4, 3, 2]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    private final Random random = ThreadLocalRandom.current();

    @Test
    void randomTests() {
        for (int run = 0; run < 100; ++run) {
            int[] numbers = random.ints(random.nextLong(15), 0, random.nextInt(1, 30)).toArray();
            test(numbers, refsol(numbers));
        }
    }

    private void test(int[] numbers, int[] expected) {
        int[] input = numbers.clone();
        int[] actual = Remover.removeSmallest(input);
        assertArrayEquals(numbers, input, "You should not modify the input!");
        assertArrayEquals(expected, actual,
                "For numbers = " + Arrays.toString(numbers) + ":\nexpected: " + Arrays.toString(expected) + "\nactual:   " + Arrays.toString(actual) + "\n");
    }

    private int[] refsol(int[] numbers) {
        if (numbers.length < 2) return new int[0];
        int pos = indexOf(numbers, Arrays.stream(numbers).min().orElseThrow());
        return IntStream.range(0, numbers.length).filter(i -> i != pos).map(i -> numbers[i]).toArray();
    }

    private int indexOf(int[] array, int v) {
        for (int i = 0; i < array.length; ++i)
            if (array[i] == v) return i;
        return -1;
    }
}