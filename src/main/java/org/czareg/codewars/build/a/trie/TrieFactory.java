package org.czareg.codewars.build.a.trie;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The goal of this kata is to implement trie (or prefix tree) using dictionaries (aka hash maps or hash tables), where:

the dictionary keys are the prefixes
the value of a leaf node is None in Python, nil in Ruby, null in Groovy, JavaScript and Java, and Nothing in Haskell.
the value for empty input is {} in Python, Ruby, Javascript and Java (empty map), [:] in Groovy, and Trie [] in Haskell.
Examples:

"trie" => "{t={tr={tri={trie=null}}}}"
"tree" => "{t={tr={tre={tree=null}}}}"
"A", "to", "tea", "ted", "ten", "i", "in", "inn" => "{A=null, t={te={tea=null, ted=null, ten=null}, to=null}, i={in={inn=null}}}"
"true", "trust" => "{t={tr={tru={true=null, trus={trust=null}}}}}"
 */
@UtilityClass
class TrieFactory {

    static Map<String, Object> buildTrie(String... words) {
        if (words == null || words.length == 0) {
            return Map.of();
        }
        List<Map<String, Object>> wordMaps = Arrays.stream(words)
                .map(TrieFactory::wordToMap)
                .toList();
        return mergeMaps(wordMaps);
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> wordToMap(String word) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> current = map;

        for (int endIndex = 1; endIndex <= word.length(); endIndex++) {
            String letters = word.substring(0, endIndex);
            if (letters.equals(word)) {
                current.put(letters, null);
                break;
            }
            Map<String, Object> next = (Map<String, Object>) current.getOrDefault(letters, new HashMap<>());
            current.put(letters, next);
            current = next;
        }

        return map;
    }

    public static Map<String, Object> mergeMaps(List<Map<String, Object>> wordMaps) {
        Map<String, Object> result = new HashMap<>();
        for (Map<String, Object> wordMap : wordMaps) {
            merge(result, wordMap);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private static void merge(Map<String, Object> merged, Map<String, Object> toMerge) {
        for (Map.Entry<String, Object> entry : toMerge.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!merged.containsKey(key)) {
                merged.put(key, value);
                continue;
            }
            Object existingValue = merged.get(key);
            if (value != null && existingValue != null) {
                merge((Map<String, Object>) existingValue, (Map<String, Object>) value);
            } else {
                merged.put(key, value != null ? value : existingValue);
            }
        }
    }
}