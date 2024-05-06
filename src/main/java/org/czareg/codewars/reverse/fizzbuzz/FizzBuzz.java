package org.czareg.codewars.reverse.fizzbuzz;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

/*
FizzBuzz is often one of the first programming puzzles people learn. Now undo it with reverse FizzBuzz!

Write a function that accepts a string, which will always be a valid section of FizzBuzz. Your function must return an array
that contains the numbers in order to generate the given section of FizzBuzz.

Notes:

If the sequence can appear multiple times within FizzBuzz, return the numbers that generate the first instance of that sequence.
All numbers in the sequence will be greater than zero.
You will never receive an empty sequence.
Examples
reverse_fizzbuzz("1 2 Fizz 4 Buzz")        -->  [1, 2, 3, 4, 5]
reverse_fizzbuzz("Fizz 688 689 FizzBuzz")  -->  [687, 688, 689, 690]
reverse_fizzbuzz("Fizz Buzz")              -->  [9, 10]
 */
@UtilityClass
public class FizzBuzz {

    private static final Pattern IS_DIGITS_ONLY = Pattern.compile("\\d+");

    public static List<Integer> reverseFizzBuzz(String input) {
        if (input == null || input.isEmpty()) {
            return List.of();
        }
        return switch (input) {
            case "Fizz" -> List.of(3);
            case "Buzz" -> List.of(5);
            case "FizzBuzz" -> List.of(15);
            case "Fizz Buzz", "Fizz FizzBuzz", "FizzBuzz Buzz" -> List.of(9, 10);
            case "Buzz FizzBuzz", "Buzz Fizz", "FizzBuzz Fizz" -> List.of(5, 6);
            default -> calculate(input);
        };
    }

    private static List<Integer> calculate(String input) {
        List<String> numberOrTypes = stream(input.split(" "))
                .collect(toCollection(ArrayList::new));

        for (int i = 0; i < numberOrTypes.size(); i++) {
            tryToReplaceForIndex(numberOrTypes, i);
        }
        tryToReplaceForIndex(numberOrTypes, 0);
        tryToReplaceForIndex(numberOrTypes, numberOrTypes.size() - 1);

        return numberOrTypes.stream().map(Integer::valueOf).toList();
    }

    private static void tryToReplaceForIndex(List<String> numberOrTypes, int i) {
        String current = numberOrTypes.get(i);
        if (isNumber(current)) {
            return;
        }
        if (i - 1 >= 0) {
            String prev = numberOrTypes.get(i - 1);
            if (isNumber(prev)) {
                numberOrTypes.set(i, String.valueOf(Integer.parseInt(prev) + 1));
            }
        }

        if (i + 1 < numberOrTypes.size()) {
            String next = numberOrTypes.get(i + 1);
            if (isNumber(next)) {
                numberOrTypes.set(i, String.valueOf(Integer.parseInt(next) - 1));
            }
        }
    }

    private static boolean isNumber(String input) {
        return IS_DIGITS_ONLY.matcher(input).matches();
    }
}