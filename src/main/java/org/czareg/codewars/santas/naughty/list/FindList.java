package org.czareg.codewars.santas.naughty.list;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Christmas is coming, and Santa has a long list to go through, to find who deserves presents for the big day.
Go through a list of children, and return a list containing every child who appeared on Santa's list.
Do not add any child more than once. Output should be sorted.

For java, use Lists.

Comparison should be case sensitive and the returned list should contain only one copy of each name:
"Sam" and "sam" are different, but "sAm" and "sAm" are not.
 */
@UtilityClass
public class FindList {

    public static List<String> findChildren(List<String> santasList, List<String> children) {
        Set<String> santasSet = new HashSet<>(santasList);
        return children.stream()
                .filter(santasSet::contains)
                .distinct()
                .sorted()
                .toList();
    }
}
