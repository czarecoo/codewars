package org.czareg.codewars.dashatize.it;

import lombok.experimental.UtilityClass;

/*
Given an integer, return a string with dash '-' marks before and after each odd digit, but do not begin or end the string with a dash mark.
Ex:
274 -> '2-7-4'
6815 -> '68-1-5'
 */
@UtilityClass
public class Dasher {

    public static String dashatize(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int mod = num % 10;
            if (mod < 0) {
                mod = -mod;
            }
            if (mod % 2 != 0) {
                stringBuilder.append("-%s-".formatted(mod));
            } else {
                stringBuilder.append(mod);
            }
            num /= 10;
        }
        stringBuilder.reverse();
        int firstIndex = 0;
        if (stringBuilder.charAt(firstIndex) == '-') {
            stringBuilder.deleteCharAt(firstIndex);
        }
        int lastIndex = stringBuilder.length() - 1;
        if (stringBuilder.charAt(lastIndex) == '-') {
            stringBuilder.deleteCharAt(lastIndex);
        }

        for (int i = 1; i < stringBuilder.length() - 1; i++) {
            char previous = stringBuilder.charAt(i - 1);
            char current = stringBuilder.charAt(i);
            if (previous == '-' && current == '-') {
                stringBuilder.deleteCharAt(i - 1);
                i--;
            }
        }
        return stringBuilder.toString();
    }
}
