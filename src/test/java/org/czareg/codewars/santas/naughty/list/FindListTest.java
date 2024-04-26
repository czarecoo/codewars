package org.czareg.codewars.santas.naughty.list;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindListTest {

    @Test
    void basicTest() {
        List<String> santasList = new ArrayList<>(Arrays.asList("Jason", "Jackson", "Jordan", "Johnny"));
        List<String> children = new ArrayList<>(Arrays.asList("Jason", "Jordan", "Jennifer"));
        List<String> expected = new ArrayList<>(Arrays.asList("Jason", "Jordan"));

        assertEquals(expected, FindList.findChildren(santasList, children));
    }

    @Test
    void sortingTest() {
        List<String> santasList = new ArrayList<>(Arrays.asList("Jason", "Jackson", "Johnson", "JJ"));
        List<String> children = new ArrayList<>(Arrays.asList("Jason", "James", "JJ"));
        List<String> expected = new ArrayList<>(Arrays.asList("JJ", "Jason"));

        assertEquals(expected, FindList.findChildren(santasList, children));
    }

    @Test
    void capitalizationTest() {
        List<String> santasList = new ArrayList<>(Arrays.asList("jASon", "JAsoN", "JaSON", "jasON"));
        List<String> children = new ArrayList<>(Arrays.asList("JasoN", "jASOn", "JAsoN", "jASon", "JASON"));
        List<String> expected = new ArrayList<>(Arrays.asList("JAsoN", "jASon"));

        assertEquals(expected, FindList.findChildren(santasList, children));
    }

    @Test
    void randomTest() {
        for (int k = 0; k < 50; k++) {
            List<String> santasList = new ArrayList<>();
            List<String> children = new ArrayList<>();
            String[] adders = new String[100];
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 5 + (int) (Math.random() * 15); j++) {
                    s.append((char) (65 + (int) (57 * Math.random())));
                }
                adders[i] = s.toString();
                s = new StringBuilder();
            }
            for (int i = 0; i < 50 + (int) (15 * Math.random()); i++) {
                santasList.add(adders[(int) (100 * Math.random())]);
            }
            for (int i = 0; i < 50 + (int) (15 * Math.random()); i++) {
                children.add(adders[(int) (100 * Math.random())]);
            }
            assertEquals(solution(santasList, children), FindList.findChildren(santasList, children));
        }
    }

    private static List<String> solution(List<String> santasList, List<String> children) {
        List<String> goodChildren = new ArrayList<>();
        for (String str : santasList) {
            if (children.contains(str)) {
                goodChildren.add(str);
            }
        }
        Set<String> removeDups = new HashSet<>(goodChildren);
        goodChildren.clear();
        goodChildren.addAll(removeDups);
        Collections.sort(goodChildren);
        return goodChildren;
    }
}