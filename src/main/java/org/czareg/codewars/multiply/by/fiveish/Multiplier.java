package org.czareg.codewars.multiply.by.fiveish;

import lombok.experimental.UtilityClass;

/*
Jack really likes his number five: the trick here is that you have to multiply each number by 5 raised to the number of digits of each numbers, so, for example:

Kata.multiply(3) == 15      // 3 * 5¹
Kata.multiply(10) == 250    // 10 * 5²
Kata.multiply(200) == 25000 // 200 * 5³
Kata.multiply(0) == 0       // 0 * 5¹
Kata.multiply(-3) == -15    // -3 * 5¹
 */
@UtilityClass
public class Multiplier {

    public static int multiply(int number) {
        int characters = String.valueOf(Math.abs(number)).length();
        return (int) (number * Math.pow(5, characters));
    }
}
