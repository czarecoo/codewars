package org.czareg.codewars.string.incrementer;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.math.BigInteger;

/*
Your job is to write a function which increments a string, to create a new string.

If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.
Examples:

foo -> foo1
foobar23 -> foobar24
foo0042 -> foo0043
foo9 -> foo10
foo099 -> foo100

Attention: If the number has leading zeros the amount of digits should be considered.
 */
@UtilityClass
public class StringIncrementer {

    public static String incrementString(@NonNull String str) {
        if (str.isEmpty()) {
            return "1";
        }
        char[] charArray = str.toCharArray();
        Integer indexOfFirstTrailingDigit = findIndexOfFirstTrailingDigitOrNull(str, charArray);
        if (indexOfFirstTrailingDigit == null) {
            return str + 1;
        }
        String strOnlyTrailingDigits = str.substring(indexOfFirstTrailingDigit);
        String strWithoutTrailingDigits = str.substring(0, indexOfFirstTrailingDigit);
        BigInteger digits = new BigInteger(strOnlyTrailingDigits);
        BigInteger incrementedDigits = digits.add(BigInteger.ONE);
        String format = "%s%0" + strOnlyTrailingDigits.length() + "d";
        return String.format(format, strWithoutTrailingDigits, incrementedDigits);
    }

    private static Integer findIndexOfFirstTrailingDigitOrNull(String str, char[] charArray) {
        Integer indexOfFirstTrailingDigit = null;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isDigit(charArray[i])) {
                indexOfFirstTrailingDigit = i;
            } else {
                break;
            }
        }
        return indexOfFirstTrailingDigit;
    }
}