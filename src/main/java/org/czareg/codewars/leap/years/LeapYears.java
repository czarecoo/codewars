package org.czareg.codewars.leap.years;

import lombok.experimental.UtilityClass;

/*
In this kata you should simply determine, whether a given year is a leap year or not. In case you don't know the rules, here they are:

Years divisible by 4 are leap years,
but years divisible by 100 are not leap years,
but years divisible by 400 are leap years.
Tested years are in range 1600 ≤ year ≤ 4000.

----
Year.isLeap(year) <- best solution
 */
@UtilityClass
public class LeapYears {

    public static boolean isLeapYear(int year) {
        Dividend dividend = new Dividend(year);
        return dividend.isDividableBy(400) || dividend.isDividableBy(4) && !dividend.isDividableBy(100);
    }

    record Dividend(int num) {

        boolean isDividableBy(int divisor) {
            return num % divisor == 0;
        }
    }
}
