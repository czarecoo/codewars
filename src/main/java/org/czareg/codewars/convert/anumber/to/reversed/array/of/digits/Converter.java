package org.czareg.codewars.convert.anumber.to.reversed.array.of.digits;

import lombok.experimental.UtilityClass;

/*
Convert number to reversed array of digits
Given a random non-negative number, you have to return the digits of this number within an array in reverse order.

Example(Input => Output):
35231 => [1,3,2,5,3]
0 => [0]
 */
@UtilityClass
class Converter {

    static int[] digitize(long n) {
        return new StringBuilder()
                .append(n)
                .reverse()
                .toString()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
