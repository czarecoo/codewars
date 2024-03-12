package org.czareg.codewars.one.two.three;

import lombok.experimental.UtilityClass;

/*
There are no explanations. You have to create the code that gives the following results:
oneTwoThree(0) == ['0', '0']
oneTwoThree(1) == ['1', '1']
oneTwoThree(3) == ['3', '111']
oneTwoThree(19) == ['991', '1111111111111111111']
 */
@UtilityClass
public class OneTwoThree {

    public static String[] oneTwoThree(int n) {
        if (n <= 0) {
            return new String[]{"0", "0"};
        }
        return new String[]{prepareFirstString(n), prepareSecondString(n)};
    }

    private static String prepareFirstString(int n) {
        String firstPartOfFirstString = "9".repeat(n / 9);
        int nModuloNine = n % 9;
        String secondPartOfFirstString = nModuloNine != 0 ? String.valueOf(nModuloNine) : "";
        return firstPartOfFirstString + secondPartOfFirstString;
    }

    private static String prepareSecondString(int n) {
        return "1".repeat(n);
    }
}
