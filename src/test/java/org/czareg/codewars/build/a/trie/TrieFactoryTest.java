package org.czareg.codewars.build.a.trie;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrieFactoryTest {

    private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    void fixedTests() {
        assertEquals("{t={tr={tri={trie=null}}}}", TrieFactory.buildTrie("trie").toString());
        assertEquals("{t={tr={tre={tree=null}}}}", TrieFactory.buildTrie("tree").toString());
        assertEquals("{t={tr={tri={trie=null}}}}", TrieFactory.buildTrie("trie", "trie").toString());
        assertEquals("{A=null, t={te={tea=null, ted=null, ten=null}, to=null}, i={in={inn=null}}}", TrieFactory.buildTrie("A", "to", "tea", "ted", "ten", "i", "in", "inn").toString());
        assertEquals("{t={tr={tru={true=null, trus={trust=null}}}}}", TrieFactory.buildTrie("true", "trust").toString());
    }

    @Test
    void edgeCase() {
        assertEquals("{}", TrieFactory.buildTrie().toString());
        assertEquals("{}", TrieFactory.buildTrie("").toString());
        assertEquals("{}", TrieFactory.buildTrie("", "").toString());
        assertEquals("{t={to={tot={tota={total=null}}}}}", TrieFactory.buildTrie("total", "to").toString());
    }

    private static Map<String, Object> _solution(String... words) {
        Map<String, Object> root = new HashMap<>();
        for (String word : words) {
            Map focusNode = root;
            for (int i = 1; i <= word.length(); i++) {
                String str = word.substring(0, i);
                focusNode.putIfAbsent(str, (str.equals(word) ? null : new HashMap<String, Object>()));
                focusNode = (HashMap<String, Object>) focusNode.get(str);
            }
        }
        return root;
    }

    @Test
    void randomTests() {
        Function<String[], Map<String, Object>> solution = words -> {
            Map<String, Object> trie = new HashMap<>();
            for (String word : words) {
                Map<String, Object> node = trie;
                String str = "";
                for (char c : word.toCharArray()) {
                    str += c;
                    node.putIfAbsent(str, str.equals(word) ? null : new HashMap<>());
                    node = (Map<String, Object>) node.get(str);
                }
            }
            return trie;
        };
        for (int i = 0; i < 100; i++) {
            String[] words = randomArray(50);
            assertEquals(solution.apply(words), _solution(words));
        }
    }

    private String randomString(int length) {
        char[] chars = new char[(int) (Math.random() * length)];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ALPHABETS.charAt((int) (Math.random() * ALPHABETS.length()));
        }
        if (Math.random() * 8 < 1) {
            Arrays.sort(chars);
        }
        return String.valueOf(chars);
    }

    private String[] randomArray(int length) {
        String[] strings = new String[(int) (Math.random() * length)];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = randomString(30);
        }
        if (strings.length > 0) {
            String string = strings[strings.length - 1];
            String[] prefixes = new String[string.length()];
            for (int i = 0; i < prefixes.length; i++) {
                prefixes[i] = string.substring(0, i + 1);
            }
            String[] newStrings = new String[strings.length - 1 + prefixes.length];
            System.arraycopy(strings, 0, newStrings, 0, strings.length - 1);
            System.arraycopy(prefixes, 0, newStrings, strings.length - 1, prefixes.length);
            return newStrings;
        }
        return strings;
    }
}