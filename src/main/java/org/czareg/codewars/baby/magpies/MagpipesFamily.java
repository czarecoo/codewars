package org.czareg.codewars.baby.magpies;

import lombok.experimental.UtilityClass;

/*
It is a little known fact^ that the black & white colours of baby magpies differ by at least one place and at most two places from the colours of the mother magpie.

So now you can work out if any two magpies may be related.

...and Quardle oodle ardle wardle doodle the magpies said

Kata Task
Given the colours of two magpies, determine if one is a possible child or grand-child of the other.

Notes
Each pair of birds being compared will have same number of colour areas
B = Black
W = White
 */
@UtilityClass
class MagpipesFamily {

    static boolean child(final String bird1, final String bird2) {
        validateLengths(bird1, bird2);
        int differences = countDifferences(bird1, bird2);
        return differences == 1 || differences == 2;
    }

    static boolean grandchild(final String bird1, final String bird2) {
        validateLengths(bird1, bird2);
        if (bird1.length() == 1) {
            return bird1.equals(bird2);
        }
        int differences = countDifferences(bird1, bird2);
        return differences >= 0 && differences <= 4;
    }

    private static void validateLengths(String bird1, String bird2) {
        if (bird1.length() != bird2.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static int countDifferences(String bird1, String bird2) {
        int differences = 0;
        for (int i = 0; i < bird1.length(); i++) {
            if (bird1.charAt(i) != bird2.charAt(i)) {
                differences++;
            }
        }
        return differences;
    }
}
