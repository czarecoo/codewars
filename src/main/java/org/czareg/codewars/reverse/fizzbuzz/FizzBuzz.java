package org.czareg.codewars.reverse.fizzbuzz;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

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
        List<NumberOrType> numberOrTypes = Arrays.stream(input.split(" "))
                .map(NumberOrType::new)
                .toList();

        for (int i = 0; i < numberOrTypes.size(); i++) {
            tryToReplaceForIndex(numberOrTypes, i);
        }
        tryToReplaceForIndex(numberOrTypes, 0);
        tryToReplaceForIndex(numberOrTypes, numberOrTypes.size() - 1);

        return numberOrTypes.stream().filter(NumberOrType::isNumber).map(NumberOrType::getNum).toList();
    }

    private static void tryToReplaceForIndex(List<NumberOrType> numberOrTypes, int i) {
        NumberOrType current = numberOrTypes.get(i);
        if (current.isNumber()) {
            return;
        }
        if (i - 1 >= 0) {
            NumberOrType prev = numberOrTypes.get(i - 1);
            if (prev.isNumber()) {
                current.set(prev.getNum() + 1);
            }
        }

        if (i + 1 < numberOrTypes.size()) {
            NumberOrType next = numberOrTypes.get(i + 1);
            if (next.isNumber()) {
                current.set(next.getNum() - 1);
            }
        }
    }
}

enum Type {
    NUMBER, FIZZ, BUZZ, FIZZBUZZ;

    static Type getType(String token) {
        return Arrays.stream(Type.values())
                .filter(type -> type.name().equalsIgnoreCase(token))
                .findFirst().orElse(NUMBER);
    }

    boolean isNumber() {
        return this == NUMBER;
    }
}

class NumberOrType {
    Type type;
    int num;

    public NumberOrType(String token) {
        type = Type.getType(token);
        if (type == Type.NUMBER) {
            num = Integer.parseInt(token);
        }
    }

    public boolean isNumber() {
        return type.isNumber();
    }

    public void set(int number) {
        type = Type.NUMBER;
        num = number;
    }

    public int getNum() {
        return num;
    }
}