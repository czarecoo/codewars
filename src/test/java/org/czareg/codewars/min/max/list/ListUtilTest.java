package org.czareg.codewars.min.max.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUtilTest {

    @Test
    void fixedMin() {
        assertEquals(-110, ListUtil.min(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        assertEquals(0, ListUtil.min(new int[]{42, 54, 65, 87, 0}));
        assertEquals(1, ListUtil.min(new int[]{1, 2, 3, 4, 5, 10}));
        assertEquals(-10, ListUtil.min(new int[]{-1, -2, -3, -4, -5, -10}));
    }

    @Test
    void fixedMax() {
        assertEquals(56, ListUtil.max(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        assertEquals(566, ListUtil.max(new int[]{4, 6, 2, 1, 9, 63, -134, 566}));
        assertEquals(5, ListUtil.max(new int[]{5}));
        assertEquals(555, ListUtil.max(new int[]{534, 43, 2, 1, 3, 4, 5, 5, 443, 443, 555, 555}));
    }

    @Test
    void randomTests() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randLng = 2 + (random.nextInt(14) % 15);
            List<Integer> randList = new ArrayList<>();

            for (int l = 0; l < randLng; l++) {
                randList.add(random.nextInt());
            }

            assertEquals(Long.valueOf(Collections.min(randList)),
                    Long.valueOf(ListUtil.min(randList.stream().mapToInt(e -> e).toArray())));
            assertEquals(Long.valueOf(Collections.max(randList)),
                    Long.valueOf(ListUtil.max(randList.stream().mapToInt(e -> e).toArray())));
        }
    }
}