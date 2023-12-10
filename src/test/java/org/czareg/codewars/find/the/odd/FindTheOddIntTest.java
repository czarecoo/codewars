package org.czareg.codewars.find.the.odd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheOddIntTest {

    @Test
    void findTest() {
        Random rng = new Random();
        int size = rng.nextInt(1000) + 50;
        if (size % 2 == 0) size++;

        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size - 1; i += 2) {
            int even = rng.nextInt(1000);
            list.add(even);
            list.add(even);
        }

        int oddMan = rng.nextInt(1000);

        list.add(oddMan);
        Collections.shuffle(list);
        int[] randArr = new int[size];
        int j = 0;
        for (int i : list) {
            randArr[j++] = i;
        }
        assertEquals(oddMan, FindTheOddInt.findIt(randArr));
        assertEquals(5, FindTheOddInt.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        assertEquals(-1, FindTheOddInt.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        assertEquals(5, FindTheOddInt.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        assertEquals(10, FindTheOddInt.findIt(new int[]{10}));
        assertEquals(10, FindTheOddInt.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        assertEquals(1, FindTheOddInt.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}