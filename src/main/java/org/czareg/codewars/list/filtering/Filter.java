package org.czareg.codewars.list.filtering;

import lombok.experimental.UtilityClass;

import java.util.List;


/*
In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.

Example
Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
Kata.filterList(List.of(1, "a", "b", 0, 15)) => List.of(1,0,15)
Kata.filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123)) => List.of(1, 2, 123)
 */
@UtilityClass
public class Filter {

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(Integer.class::isInstance)
                .toList();
    }
}
