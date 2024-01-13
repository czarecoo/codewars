package org.czareg.codewars.counting.duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingDuplicatesTest {

    @Test
    void emptyReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount(""));
    }

    @Test
    void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    void abcdeaaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdeaa"));
    }

    @Test
    void abcdeaBReturnsTwo() {
        assertEquals(2, CountingDuplicates.duplicateCount("abcdeaB"));
    }

    @Test
    void IndivisibilitiesReturnsTwo() {
        assertEquals(2, CountingDuplicates.duplicateCount("Indivisibilities"));
    }

    @Test
    void abcdefghijklmnopqrstuvwxyzReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void abcdefghijklmnopqrstuvwxyzaaAbReturnsTwo() {
        assertEquals(2, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzaaAb"));
    }

    @Test
    void abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzReturnsTwentySix() {
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix() {
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}