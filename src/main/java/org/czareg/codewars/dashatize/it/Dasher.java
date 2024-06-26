package org.czareg.codewars.dashatize.it;

import lombok.experimental.UtilityClass;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Given an integer, return a string with dash '-' marks before and after each odd digit, but do not begin or end the string with a dash mark.
Ex:
274 -> '2-7-4'
6815 -> '68-1-5'
 */
@UtilityClass
public class Dasher {

    public static String dashatize(int num) {
        return Pattern.compile("[13579]|[02468]+")
                .matcher(Integer.toString(num))
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining("-"));
    }
}
