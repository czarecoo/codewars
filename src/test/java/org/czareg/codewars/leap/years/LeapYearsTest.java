package org.czareg.codewars.leap.years;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LeapYearsTest {

    @DisplayName("Leap years divisible by 4")
    @ParameterizedTest(name = "isLeapYear({0}) should return true")
    @ValueSource(ints = {2020, 1824, 2152})
    @Order(1)
    void testRegularLeap(int year) {
        doTest(year, true);
    }

    @DisplayName("Non-leap years ot divisible by 4")
    @ParameterizedTest(name = "isLeapYear({0}) should return false")
    @ValueSource(ints = {1821, 1942, 2113, 2254})
    @Order(2)
    void testRegularNonLeap(int year) {
        doTest(year, false);
    }

    @DisplayName("Non-leap years divisible by 100")
    @ParameterizedTest(name = "isLeapYear({0}) should return false")
    @ValueSource(ints = {1800, 1900, 2100, 2200})
    @Order(3)
    void testNonLeapMul100(int year) {
        doTest(year, false);
    }

    @DisplayName("Leap years divisible by 400")
    @ParameterizedTest(name = "isLeapYear({0}) should return true")
    @ValueSource(ints = {1600, 2000, 4000})
    @Order(4)
    void testLeapMul400(int year) {
        doTest(year, true);
    }

    private static int randint(int hi_incl) {
        return ThreadLocalRandom.current().nextInt(1, hi_incl + 1);
    }

    @DisplayName("Random tests")
    @ParameterizedTest(name = "isLeapYear({0}) should return {1}")
    @MethodSource("generateRandomTestArgs")
    void testRandom(int year, boolean expected) {
        doTest(year, expected);
    }

    static Stream<Arguments> generateRandomTestArgs() {

        int[] yearMul400 = IntStream.of(1600, 2000, 2400, 2800, 3200, 3600).toArray();
        int[] yearMul100 = Arrays.stream(yearMul400).flatMap(year -> IntStream.of(year + 100, year + 200, year + 300)).toArray();
        int[] yearMul4 = IntStream.concat(Arrays.stream(yearMul400), Arrays.stream(yearMul100)).map(year -> year + randint(24) * 4).toArray();
        int[] yearNonMul4 = Arrays.stream(yearMul4).map(year -> year + randint(3)).toArray();

        var testCases =
                Stream.concat(
                        IntStream.concat(Arrays.stream(yearMul400), Arrays.stream(yearMul4)).mapToObj(year -> Arguments.of(year, true)),
                        IntStream.concat(Arrays.stream(yearMul100), Arrays.stream(yearNonMul4)).mapToObj(year -> Arguments.of(year, false))
                ).collect(Collectors.toList());

        Collections.shuffle(testCases);
        return testCases.stream();
    }

    private void doTest(int year, boolean expected) {
        assertEquals(expected, LeapYears.isLeapYear(year), "Incorrect answer for year " + year);
    }
}