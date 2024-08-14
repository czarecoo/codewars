package org.czareg.codewars.what.century.is.it;

import lombok.experimental.UtilityClass;

/*
Return the century of the input year. The input will always be a 4 digit string, so there is no need for validation.

Examples
"1999" --> "20th"
"2011" --> "21st"
"2154" --> "22nd"
"2259" --> "23rd"
"1124" --> "12th"
"2000" --> "20th"
 */
@UtilityClass
public class CenturyFinder {

    public static String whatCentury(int year) {
        int century = (int) Math.ceil(year / 100.0);
        int lastTwoDigits = century % 100;
        return century + ending(lastTwoDigits);
    }

    private static String ending(int lastTwoDigits) {
        if (lastTwoDigits >= 11 && lastTwoDigits <= 13) {
            return "th";
        }
        int lastDigit = lastTwoDigits % 10;
        return switch (lastDigit) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }
}