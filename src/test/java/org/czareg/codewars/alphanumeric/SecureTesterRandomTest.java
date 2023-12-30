package org.czareg.codewars.alphanumeric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecureTesterRandomTest {

    @DisplayName("Random tests")
    @ParameterizedTest(name = "Should return {1} for \"{0}\"")
    @MethodSource("generateRandomTestCases")
    void testRandomInput(String input, boolean expected) {
        assertEquals(expected, SecureTester.alphanumeric(input));
    }

    private static final Random rnd = new Random();
    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String INVALID_CHARACTERS = "_;'\\:\"|<>?,./' ąĄśŚßΑα😀😃😄✂️📋👌０１２３４５６７８９";

    private static String generateValidInput() {
        return rnd.ints(0, VALID_CHARACTERS.length())
                .mapToObj(i -> "" + VALID_CHARACTERS.charAt(i))
                .limit(rnd.nextInt(50) + 1)
                .collect(Collectors.joining(""));
    }

    private static String generateInvalidInput() {
        StringBuilder sb = new StringBuilder(generateValidInput());
        int invalidCharsToInsert = rnd.nextInt(3) + 1;
        for (int i = 0; i < invalidCharsToInsert; ++i) {
            int pos = rnd.nextInt(0, sb.length());
            sb.insert(pos, INVALID_CHARACTERS.charAt(rnd.nextInt(INVALID_CHARACTERS.length())));
        }
        return sb.toString();
    }

    private static Stream<Arguments> generateRandomTestCases() {
        var testCases = Stream.concat(
                Stream.generate(SecureTesterRandomTest::generateValidInput).map(s -> Arguments.of(s, true)).limit(50),
                Stream.generate(SecureTesterRandomTest::generateInvalidInput).map(s -> Arguments.of(s, false)).limit(50)
        ).collect(Collectors.toList());
        Collections.shuffle(testCases);
        return testCases.stream();
    }
}