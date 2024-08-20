package org.czareg.codewars.sum.of.a.sequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceSumTest {

    @Test
    @DisplayName("Basic tests")
    void basicTests() {
        assertEquals(12, SequenceSum.sequenceSum(2, 6, 2), "sequenceSum(2, 6, 2)");
        assertEquals(15, SequenceSum.sequenceSum(1, 5, 1), "sequenceSum(1, 5, 1)");
        assertEquals(5, SequenceSum.sequenceSum(1, 5, 3), "sequenceSum(1, 5, 3)");
        assertEquals(45, SequenceSum.sequenceSum(0, 15, 3), "sequenceSum(0, 15, 3)");
        assertEquals(0, SequenceSum.sequenceSum(16, 15, 3), "sequenceSum(16, 15, 3)");
        assertEquals(26, SequenceSum.sequenceSum(2, 24, 22), "sequenceSum(2, 24, 22)");
        assertEquals(2, SequenceSum.sequenceSum(2, 2, 2), "sequenceSum(2, 2, 2)");
        assertEquals(2, SequenceSum.sequenceSum(2, 2, 1), "sequenceSum(2, 2, 1)");
        assertEquals(35, SequenceSum.sequenceSum(1, 15, 3), "sequenceSum(1, 15, 3)");
        assertEquals(0, SequenceSum.sequenceSum(15, 1, 3), "sequenceSum(15, 1, 3)");
    }

    @Test
    @DisplayName("Random tests")
    void randomTests() {
        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < 50; ++i) {
            int start = rnd.nextInt(1000);
            int end = rnd.nextInt(1000);
            int step = rnd.nextInt(1, 100);
            int sum = 0;
            for (int j = start; j <= end; j += step) {
                sum += j;
            }
            assertEquals(sum, SequenceSum.sequenceSum(start, end, step), String.format("sequenceSum(%d, %d, %d)", start, end, step));
        }
    }
}