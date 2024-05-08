package org.czareg.codewars.make.me.slow;

import lombok.experimental.UtilityClass;

/*
Make me slow! Calling makeMeSlow() should take at least 2 seconds.
 */
@UtilityClass
public class Slow {

    private static final int TWO_SECONDS = 2 * 1000;

    public static void makeMeSlow() {
        try {
            Thread.sleep(TWO_SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }
}
