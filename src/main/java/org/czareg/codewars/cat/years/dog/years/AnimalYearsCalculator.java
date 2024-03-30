package org.czareg.codewars.cat.years.dog.years;

import lombok.experimental.UtilityClass;

/*
I have a cat and a dog.

I got them at the same time as kitten/puppy. That was humanYears years ago.

Return their respective ages now as [humanYears,catYears,dogYears]

NOTES:

humanYears >= 1
humanYears are whole numbers only
Cat Years
15 cat years for first year
+9 cat years for second year
+4 cat years for each year after that
Dog Years
15 dog years for first year
+9 dog years for second year
+5 dog years for each year after that
 */
@UtilityClass
public class AnimalYearsCalculator {

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {
        if (humanYears < 1) {
            throw new IllegalArgumentException();
        }
        return new int[]{humanYears, calculateCatYears(humanYears), calculateDogYears(humanYears)};
    }

    private static int calculateCatYears(int humanYears) {
        return switch (humanYears) {
            case 1 -> 15;
            case 2 -> 15 + 9;
            default -> 15 + 9 + (humanYears - 2) * 4;
        };
    }

    private static int calculateDogYears(int humanYears) {
        return switch (humanYears) {
            case 1 -> 15;
            case 2 -> 15 + 9;
            default -> 15 + 9 + (humanYears - 2) * 5;
        };
    }
}
