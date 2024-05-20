package org.czareg.codewars.sort.the.gift.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiftSorterTest {

    @Test
    void simpleTests1() {
        assertEquals("abcdef", GiftSorter.sortGiftCode("fedcba"));
    }

    @Test
    void simpleTests2() {
        assertEquals("abcdef", GiftSorter.sortGiftCode("abcdef"));
    }

    @Test
    void simpleTests3() {
        assertEquals("kpqsuvy", GiftSorter.sortGiftCode("pqksuvy"));
    }

    @Test
    void simpleTests4() {
        assertEquals("abcdefghijklmnopqrstuvwxyz", GiftSorter.sortGiftCode("zyxwvutsrqponmlkjihgfedcba"));
    }

    @Test
    void simpleTests5() {
        assertEquals("z", GiftSorter.sortGiftCode("z"));
    }
}