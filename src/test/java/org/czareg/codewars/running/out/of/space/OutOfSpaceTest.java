package org.czareg.codewars.running.out.of.space;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OutOfSpaceTest {

    @Test
    @Order(1)
    @DisplayName("Strings with lower letters only")
    void test1() {
        String[] input = new String[]{"kevin", "has", "no", "space"};
        String[] expected = new String[]{"kevin", "kevinhas", "kevinhasno", "kevinhasnospace"};
        assertArrayEquals(expected, OutOfSpace.spacey(input));
    }

    @Test
    @Order(2)
    @DisplayName("Strings with camel case")
    void test2() {
        String[] input = new String[]{"Camel", "Case", "Should", "Remain"};
        String[] expected = new String[]{"Camel", "CamelCase", "CamelCaseShould", "CamelCaseShouldRemain"};
        assertArrayEquals(expected, OutOfSpace.spacey(input));
    }

    @Test
    @Order(3)
    @DisplayName("Strings with letters, digits,")
    void test3() {
        String[] input = new String[]{"Trying!", "Adding2", "Diff3rent", "Comb1nati0ns"};
        String[] expected = new String[]{"Trying!", "Trying!Adding2", "Trying!Adding2Diff3rent", "Trying!Adding2Diff3rentComb1nati0ns"};
        assertArrayEquals(expected, OutOfSpace.spacey(input));
    }

    @Test
    @Order(4)
    @DisplayName("Random tests")
    void randomTests() {
        String[][] arrayOfWords = {
                {"This", "That", "The", "Some", "Many"},
                {"kevin", "cheese", "kata", "CodeWarrior", "racoon"},
                {"has", "likes", "hates", "enjoys", "watches"},
                {"big", "pink", "tiny", "small", "green"},
                {"space", "holes", "bugs", "legs", "eyes"}
        };

        for (int i = 0; i < 100; i++) {
            StringBuilder sentence = new StringBuilder();
            for (String[] arrayOfWord : arrayOfWords) {
                int randomNum = new Random().nextInt(4 + 1);
                sentence.append(arrayOfWord[randomNum]).append(" ");
            }
            String[] input = sentence.toString().split("\\s");
            String[] actual = OutOfSpace.spacey(Arrays.copyOf(input, input.length));
            assertArrayEquals(solution(input), actual);
        }
    }

    private static String[] solution(String[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
        }
        return array;
    }
}