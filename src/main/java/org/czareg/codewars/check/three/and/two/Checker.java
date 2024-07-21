package org.czareg.codewars.check.three.and.two;

import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an array with exactly 5 strings "a", "b" or "c" (chars in Java, characters in Fortran), check if the array contains three and two of the same values.

Examples
["a", "a", "a", "b", "b"] ==> true  // 3x "a" and 2x "b"
["a", "b", "c", "b", "c"] ==> false // 1x "a", 2x "b" and 2x "c"
["a", "a", "a", "a", "a"] ==> false // 5x "a"
 */
@UtilityClass
public class Checker {

    private static final Set<Long> REQUIRED_CHARACTER_COUNTS = Set.of(3L, 2L);

    public boolean checkThreeAndTwo(char[] chars) {
        return IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .containsAll(REQUIRED_CHARACTER_COUNTS);
    }
}
