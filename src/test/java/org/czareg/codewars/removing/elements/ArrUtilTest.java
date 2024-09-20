package org.czareg.codewars.removing.elements;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrUtilTest {

    @Test
    @Order(1)
    void basicTest() {
        assertArrayEquals(new Object[]{"Hello", "Hello Again"},
                ArrUtil.removeEveryOther(new Object[]{"Hello", "Goodbye", "Hello Again"}));
        assertArrayEquals(new Object[]{new Object[]{1, 2}},
                ArrUtil.removeEveryOther(new Object[]{new Object[]{1, 2}}));
        assertArrayEquals(new Object[]{1, 3, 5, 7, 9},
                ArrUtil.removeEveryOther(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertArrayEquals(new Object[]{"Goodbye"}, ArrUtil.removeEveryOther(new Object[]{"Goodbye"}));
        assertArrayEquals(new Object[]{}, ArrUtil.removeEveryOther(new Object[]{}));
    }

    @Test
    @Order(2)
    void randomTest() {
        Random rnd = new Random();
        for (int run = 0; run < 40; ++run) {
            List<Object> input = new ArrayList<>();
            List<Object> expected = new ArrayList<>();
            int len = rnd.nextInt(5) == 0 ? rnd.nextInt(4) : rnd.nextInt(1000);
            for (int i = 0; i < len; ++i) {
                Object o = makeObject(rnd, 4);
                input.add(o);
                if (i % 2 == 0) {
                    expected.add(o);
                }
            }
            assertArrayEquals(expected.toArray(), ArrUtil.removeEveryOther(input.toArray()));
        }
    }

    private Object makeObject(Random rnd, int cases) {
        return switch (rnd.nextInt(cases)) {
            case 0 -> rnd.nextInt(-10000, 10000);
            case 1 ->
                    rnd.ints(rnd.nextLong(10), 32, 127).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            case 2 -> IntStream.range(0, rnd.nextInt(5)).mapToObj(i -> makeObject(rnd, 2)).toArray();
            case 3 -> IntStream.range(0, rnd.nextInt(5)).mapToObj(i -> makeObject(rnd, 2)).toList();
            default -> null;
        };
    }
}