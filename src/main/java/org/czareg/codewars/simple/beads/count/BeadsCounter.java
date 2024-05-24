package org.czareg.codewars.simple.beads.count;

import lombok.experimental.UtilityClass;

/*
Two red beads are placed between every two blue beads. There are N blue beads. After looking at the arrangement below work out the number of red beads.

B RR B RR B RR B RR B RR B

Implement method so that it returns the number of red beads.
If there are less than 2 blue beads return 0.
 */
@UtilityClass
public class BeadsCounter {

    public static int countRedBeads(final int nBlue) {
        if (nBlue < 2) {
            return 0;
        }
        return 2 * (nBlue - 1);
    }
}