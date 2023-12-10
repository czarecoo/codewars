package org.czareg.codewars.opposites.attract;

import lombok.experimental.UtilityClass;

/*
Timmy & Sarah think they are in love, but around where they live, they will only know once they pick a flower each.
If one of the flowers has an even number of petals and the other has an odd number of petals it means they are in love.

Write a function that will take the number of petals of each flower and return true if they are in love and false if they aren't.
 */
@UtilityClass
public class OppositesAttract {

    public static boolean isLove(final int flower1, final int flower2) {
        return isEven(flower1) && isOdd(flower2) || isOdd(flower1) && isEven(flower2);
    }

    private static boolean isOdd(int i) {
        return !isEven(i);
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
}
