package org.czareg.codewars.sort.my.textbooks;

import lombok.experimental.UtilityClass;

import java.util.List;

/*
HELP! Jason can't find his textbook! It is two days before the test date, and Jason's textbooks are all out of order!
Help him sort a list (ArrayList in java) full of textbooks by subject, so he can study before the test.

The sorting should NOT be case sensitive
 */
@UtilityClass
public class Sorter {

    public static List<String> sort(List<String> textbooks) {
        return textbooks.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }
}
