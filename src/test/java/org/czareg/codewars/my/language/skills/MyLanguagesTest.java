package org.czareg.codewars.my.language.skills;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLanguagesTest {

    @Test
    void basicTests() {
        final Map<String, Integer> map1 = new HashMap<>();
        map1.put("Java", 10);
        map1.put("Ruby", 80);
        map1.put("Python", 65);
        map1.put("Erlang", 60);
        assertEquals(Arrays.asList("Ruby", "Python", "Erlang"), MyLanguages.myLanguages(map1));
        final Map<String, Integer> map2 = new HashMap<>();
        map2.put("Hindi", 60);
        map2.put("Dutch", 93);
        map2.put("Greek", 71);
        assertEquals(Arrays.asList("Dutch", "Greek", "Hindi"), MyLanguages.myLanguages(map2));
        final Map<String, Integer> map3 = new HashMap<>();
        map3.put("C++", 50);
        map3.put("ASM", 10);
        map3.put("Haskell", 20);
        assertEquals(Collections.emptyList(), MyLanguages.myLanguages(map3));
    }

    @Test
    void randomTests() {
        String[] langs1 =
                "Arabic Bengali Bulgarian Chinese Croatian Czech Danish Dutch English Estonian Finnish French German Greek Hindi Hungarian Irish Italian Japanese Korean Latvian Lithuanian Maltese Polish Portuguese Punjabi Romanian Russian Slovak Slovenian Spanish Swedish Turkish"
                        .split("\\s");

        String[] langs2 =
                "ASM C Clojure CoffeeScript C++ Crystal C# Dart Elixir Erlang Fortran F# Go Groovy Haskell Java JavaScript Julia Kotlin Lua Nim Objective-C OCaml PHP PowerShell Python R Ruby Rust Scala Shell Solidity SQL Swift TypeScript"
                        .split("\\s");
        for (int i = 0; i < 50; i++) {
            String[] langs = (Math.random() > 0.5) ? langs1 : langs2;
            int n = (int) (1 + (Math.random() * 8));
            Map<String, Integer> results =
                    Stream.of(langs)
                            .parallel()
                            .collect(
                                    Collectors.collectingAndThen(
                                            Collectors.toList(),
                                            collected -> {
                                                Collections.shuffle(collected);
                                                return collected.stream();
                                            }))
                            .limit(n)
                            .collect(Collectors.toMap(o -> o, o -> (int) (Math.random() * 100)));
            assertEquals(
                    results
                            .entrySet()
                            .stream()
                            .filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 60)
                            .sorted(Comparator.comparingInt(value -> -value.getValue()))
                            .map(Map.Entry::getKey)
                            .toList(),
                    MyLanguages.myLanguages(results));
        }
    }
}