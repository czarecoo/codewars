package org.czareg.codewars.basic.sequence.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SequenceSumTest {

    @Test
    void testKnownValues() {
        assertArrayEquals(new int[]{0, 1, 3, 6}, SequenceSum.sumOfN(3));
        assertArrayEquals(new int[]{0, -1, -3, -6, -10}, SequenceSum.sumOfN(-4));
        assertArrayEquals(new int[]{0, 1}, SequenceSum.sumOfN(1));
        assertArrayEquals(new int[]{0}, SequenceSum.sumOfN(0));
        assertArrayEquals(new int[]{0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55}, SequenceSum.sumOfN(10));
    }
}