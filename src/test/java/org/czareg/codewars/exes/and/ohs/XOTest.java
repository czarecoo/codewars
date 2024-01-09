package org.czareg.codewars.exes.and.ohs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XOTest {

    @ParameterizedTest(name = "str = \"{1}\"")
    @DisplayName("Fixed tests")
    @Order(1)
    @CsvSource(textBlock = """
                true,  ooxx
                false, xooxx
                true,  ooxXm
                true,  zpzpzpp
                false, zzoo
                true,  xxxooo
                true,  xxxXooOo
                false, xxx23424esdsfvxXXOOooo
                false, xXxxoewrcoOoo
                false, XxxxooO
                true,  zssddd
                false, Xxxxertr34
                true,  ''
            """)
    void fixedTests(boolean expected, String input) {
        assertEquals(expected, XO.getXO(input));
    }

    private boolean expectXO(String str) {
        str = str.toLowerCase();
        return str.chars().filter(c -> c == 'x').count() == str.chars().filter(c -> c == 'o').count();
    }

    private static final String ALPHA_NUMERIC_STRING = "AXXXxxBXxxooOOCXXXooXXXXXXDoooXXEFXXXXoooGXXHXXxxooOOOOIJKLMNOPQOOOORSTUXXXXVWXXXYxxxxZ0oooo01XXXXX23xx45XX678XX9";

    private String randomAlphaNumeric(int count) {
        return ThreadLocalRandom.current().ints(count, 0, ALPHA_NUMERIC_STRING.length()).map(ALPHA_NUMERIC_STRING::charAt)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    @Test
    @DisplayName("Small random tests")
    @Order(2)
    void smallRandomTests() {
        for (int i = 0; i <= 20; i++) randomTest(10);
    }

    @Test
    @DisplayName("Big random tests")
    @Order(3)
    void bigRandomTests() {
        for (int i = 0; i <= 100; i++) randomTest(100);
    }

    private void randomTest(int maxSize) {
        var rnd = ThreadLocalRandom.current();
        String input = randomAlphaNumeric(rnd.nextInt(maxSize));
        boolean expected = expectXO(input);
        assertEquals(expected, XO.getXO(input), "For input \"" + input + "\"");
    }
}