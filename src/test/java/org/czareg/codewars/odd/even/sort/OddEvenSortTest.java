package org.czareg.codewars.odd.even.sort;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddEvenSortTest {

    @Test
    void testSomething() {
        assertEquals("Wleclgltihuebredrf ofsheesenasnegrof", OddEvenSort.sortMyString("Wolfeschlegelsteinhausenbergerdorff"));
        assertEquals("MTINLHENLHENGUAIYAGNL EHOYTROYTROYLTMNLRIY", OddEvenSort.sortMyString("METHIONYLTHREONYLTHREONYGLUTAMINYLARGINYL"));
        assertEquals("PEMNUTAIRSOISLCVLAOOISS NUOOLRMCOCPCIIOOCNCNOI", OddEvenSort.sortMyString("PNEUMONOULTRAMICROSCOPICSILICOVOLCANOCONIOSIS"));
        assertEquals("PEDPEDHPPRTYODS SUOSUOYOAAHRIIM", OddEvenSort.sortMyString("PSEUDOPSEUDOHYPOPARATHYROIDISM"));
        assertEquals("FOCNUIIIIIIIAIN LCIACNHLPLFCTO", OddEvenSort.sortMyString("FLOCCINAUCINIHILIPILIFICATION"));
        assertEquals("SBEMTGYHC UDRAOLPI", OddEvenSort.sortMyString("SUBDERMATOGLYPHIC"));
    }

    @Test
    void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String letters = "abcdefghijklmmoprstuwxyzABCDEFGHIJKLMNOPRSTUWXYZ";
            int randomSize = random.nextInt(10, letters.length());
            List<Character> characters = letters.substring(0, randomSize).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            Collections.shuffle(characters);
            String string = characters.stream().map(String::valueOf).collect(Collectors.joining());
            assertEquals(sortMyString(string), OddEvenSort.sortMyString(string));
        }
    }

    private String sortMyString(String s) {
        String even = IntStream.range(0, s.length())
                .filter(value -> value % 2 == 0)
                .mapToObj(operand -> "" + s.charAt(operand))
                .collect(Collectors.joining());

        String odd = IntStream.range(0, s.length())
                .filter(value -> value % 2 != 0)
                .mapToObj(operand -> "" + s.charAt(operand))
                .collect(Collectors.joining());

        return even + " " + odd;
    }
}