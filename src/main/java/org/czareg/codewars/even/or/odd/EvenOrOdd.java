package org.czareg.codewars.even.or.odd;

import lombok.experimental.UtilityClass;

/*
Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.
 */
@UtilityClass
public class EvenOrOdd {

    public static String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }
}
