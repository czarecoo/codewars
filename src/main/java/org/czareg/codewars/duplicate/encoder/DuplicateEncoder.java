package org.czareg.codewars.duplicate.encoder;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
 */
@UtilityClass
public class DuplicateEncoder {

    public static String encode(String word) {
        Set<Character> duplicatedCharacters = word.toLowerCase()
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> (char) i)
                .map(character -> duplicatedCharacters.contains(character) ? ")" : "(")
                .collect(Collectors.joining());
    }
}
