package org.czareg.codewars.exes.and.ohs;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false
 */
@UtilityClass
public class XO {

    private static final char O_LOWERCASE_CHAR = 'o';
    private static final char X_LOWERCASE_CHAR = 'x';

    public static boolean getXO(@NonNull String str) {
        Map<Character, Long> xsAndOsCounts = str.toLowerCase()
                .chars()
                .filter(c -> c == O_LOWERCASE_CHAR || c == X_LOWERCASE_CHAR)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return xsAndOsCounts.getOrDefault(O_LOWERCASE_CHAR, 0L).equals(xsAndOsCounts.getOrDefault(X_LOWERCASE_CHAR, 0L));
    }
}
