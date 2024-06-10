package org.czareg.codewars.list.filtering;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterTest {

    @Test
    void special() {
        List<Object> input = new ArrayList<>();
        input.add(null);
        assertEquals(List.of(), Filter.filterList(input));
    }

    @Test
    void examples() {
        assertEquals(List.of(1, 2), Filter.filterList(List.of(1, 2, "a", "b")));
        assertEquals(List.of(1, 0, 15), Filter.filterList(List.of(1, "a", "b", 0, 15)));
        assertEquals(List.of(1, 2, 123), Filter.filterList(List.of(1, 2, "aasf", "1", "123", 123)));
    }

    @Test
    void extras() {
        assertEquals(List.of(), Filter.filterList(List.of("a", "b", "1")));
        assertEquals(List.of(1, 2), Filter.filterList(List.of(1, 2, "a", "b")));
    }

    @Test
    void randomTest() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i < 20; i++) {
            int size = rand.nextInt(20);
            List<Object> input = new ArrayList<>();
            List<Integer> expected = new ArrayList<>();
            for (int j = 0; j < size; ++j) {
                if (rand.nextBoolean()) {
                    int n = rand.nextInt(0, 1000);
                    input.add(n);
                    expected.add(n);
                } else {
                    if (rand.nextBoolean()) {
                        input.add(rand.ints(rand.nextInt(6), 48, 123).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
                    } else {
                        input.add(Integer.toString(rand.nextInt(1000)));
                    }
                }
            }

            List<Object> result = Filter.filterList(List.copyOf(input));
            assertEquals(expected, result);
        }
    }
}