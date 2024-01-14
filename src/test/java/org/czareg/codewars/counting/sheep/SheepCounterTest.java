package org.czareg.codewars.counting.sheep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SheepCounterTest {

    static Boolean[] array1 = {true, true, true, false,
            true, true, true, true,
            true, false, true, false,
            true, false, false, true,
            true, true, true, true,
            false, false, true, true};

    static Boolean[] array2 = new Boolean[605];

    static Boolean[] array3 = new Boolean[605];

    static {
        int index = 0;
        for (; index < 500; index++)
            array2[index] = true;
        for (; index < 5; index++)
            array2[index] = null;
        for (; index < 100; index++)
            array2[index] = false;

        index = 0;
        for (; index < 505; index++)
            array3[index] = null;
        for (; index < 100; index++)
            array3[index] = false;
    }

    @Test
    void test1() {
        assertEquals(17, SheepCounter.countSheeps(array1));
    }

    @Test
    void test2() {
        assertEquals(500, SheepCounter.countSheeps(array2));
    }

    @Test
    void test3() {
        assertEquals(0, SheepCounter.countSheeps(array3));
    }
}