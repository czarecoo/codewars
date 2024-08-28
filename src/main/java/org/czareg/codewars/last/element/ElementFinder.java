package org.czareg.codewars.last.element;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

/*
Find the last element of the given argument(s). If a single argument is passed and is a list/array or a string, return its last element. It is guaranteed that there will be at least one argument and that single-argument arrays/lists/strings will not be empty.

Examples
last(Arrays.asList(1, 2, 3, 4)); // =>  4
last("xyz");                     // => "z"
last(1, 2, 3, 4);                // =>  4
last(new int[]{1, 2, 3, 4});     // =>  4
 */
@UtilityClass
public class ElementFinder {

    public static <T> T last(final List<T> list) {
        return list.getLast();
    }

    public static char last(final String string) {
        List<Character> characters = string.chars()
                .mapToObj(i -> (char) i)
                .toList();
        return last(characters);
    }

    @SafeVarargs
    public static <T> T last(final T... elements) {
        List<T> list = Arrays.stream(elements)
                .toList();
        return last(list);
    }
}
