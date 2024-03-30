package org.czareg.codewars.cat.years.dog.years;

import lombok.experimental.UtilityClass;

/*
I have a cat and a dog which I got as kitten / puppy.

I forget when that was, but I do know their current ages as catYears and dogYears.

Find how long I have owned each of my pets and return as a list [ownedCat, ownedDog]

NOTES:

Results are truncated whole numbers of "human" years
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
public class AnimalYearsCalculator2 {

    public static int[] ownedCatAndDog(final int catYears, final int dogYears) {
        return new int[]{calculateHumanYearsFromCatYears(catYears), calculateHumanYearsFromDogYears(dogYears)};
    }

    private static int calculateHumanYearsFromCatYears(int catYears) {
        if (catYears < 15) {
            return 0;
        } else if (catYears < 24) {
            return 1;
        } else {
            return (catYears - 16) / 4;
        }
    }

    private static int calculateHumanYearsFromDogYears(int dogYears) {
        if (dogYears < 15) {
            return 0;
        } else if (dogYears < 24) {
            return 1;
        } else {
            return (dogYears - 24) / 5 + 2;
        }
    }
}
