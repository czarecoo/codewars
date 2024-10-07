package org.czareg.codewars.simple.string.characters;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Predicate;

/*
In this Kata, you will be given a string and your task will be to return a list of ints detailing the count of uppercase letters, lowercase, numbers and special characters (everything else), as follows.

The order is: uppercase letters, lowercase letters, numbers and special characters.

"*'&ABCDabcde12345" --> [ 4, 5, 5, 3 ]
More examples in the test cases.

Good luck!
 */
@UtilityClass
class CharCounter {

    static int[] solve(String word) {
        List<Counter> counters = List.of(
                new Counter(Character::isUpperCase),
                new Counter(Character::isLowerCase),
                new Counter(Character::isDigit),
                new Counter(c -> !Character.isAlphabetic(c) && !Character.isDigit(c)));
        word.chars()
                .mapToObj(i -> (char) i)
                .forEach(character -> counters.forEach(counter -> counter.increaseIfTrue(character)));
        return counters.stream()
                .mapToInt(c -> c.sum)
                .toArray();
    }

    class Counter {

        Predicate<Character> predicate;
        int sum;

        Counter(Predicate<Character> predicate) {
            this.predicate = predicate;
            sum = 0;
        }

        void increaseIfTrue(char character) {
            if (predicate.test(character)) {
                sum++;
            }
        }
    }
}
