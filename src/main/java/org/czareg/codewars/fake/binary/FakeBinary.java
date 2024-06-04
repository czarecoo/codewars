package org.czareg.codewars.fake.binary;

import lombok.experimental.UtilityClass;

/*
Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and above with '1'. Return the resulting string.

Note: input will never be an empty string
 */
@UtilityClass
public class FakeBinary {

    public static String fakeBin(String numberString) {
        return numberString.chars()
                .map(FakeBinary::replaceDigitsLowerThanFiveWithZeroAndOthersWithOne)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int replaceDigitsLowerThanFiveWithZeroAndOthersWithOne(int digit) {
        if (digit < '5') {
            return '0';
        }
        return '1';
    }
}
