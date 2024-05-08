package org.czareg.codewars.make.me.slow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SlowTest {

    @Test
    void actualTest() {
        long time = System.currentTimeMillis();
        Slow.makeMeSlow();
        long timeTaken = System.currentTimeMillis() - time;
        String msg = "Time taken was " + timeTaken / 1000 + " seconds: Must take at least 2 seconds!";
        assertTrue(timeTaken >= 2000, msg);
    }
}