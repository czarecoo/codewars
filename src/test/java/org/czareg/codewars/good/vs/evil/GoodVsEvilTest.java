package org.czareg.codewars.good.vs.evil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoodVsEvilTest {

    private static final Random RANDOM = new Random();

    @DisplayName("Fixed tests")
    @ParameterizedTest(name = "Good: [{1}], Evil: [{2}]")
    @Order(1)
    @CsvSource({"Battle Result: Evil eradicates all trace of Good,1 1 1 1 1 1,1 1 1 1 1 1 1",
            "Battle Result: Good triumphs over Evil,0 0 0 0 0 10,0 1 1 1 1 0 0",
            "Battle Result: No victor on this battle field,1 0 0 0 0 0,1 0 0 0 0 0 0"})
    void fixedTests(String expected, String goodForces, String evilForces) {
        String msg = String.format("Forces of Good: %s%nForces of Evil: %s%n", goodForces, evilForces);
        assertEquals(expected, GoodVsEvil.battle(goodForces, evilForces), msg);
    }

    @DisplayName("Random tests")
    @ParameterizedTest(name = "Good: [{0}], Evil: [{1}]")
    @Order(2)
    @MethodSource("generateRandomTestCases")
    void randomTests(String goodForces, String evilForces) {
        String expected = correctBattleSolution(goodForces, evilForces);
        String msg = String.format("Forces of Good: [%s]%nForces of Evil: [%s]%n", goodForces, evilForces);
        assertEquals(expected, GoodVsEvil.battle(goodForces, evilForces), msg);
    }

    private static Stream<Arguments> generateRandomTestCases() {
        return Stream.generate(() -> {
            String goodForces = generateRandomString(6);
            String evilForces = generateRandomString(7);
            return Arguments.of(goodForces, evilForces);
        }).limit(100);
    }

    private static String generateRandomString(int numNumbers) {
        return RANDOM.ints(0, 10000).mapToObj(Integer::toString).limit(numNumbers).collect(Collectors.joining(" "));
    }

    private static String correctBattleSolution(final String goodAmounts, final String evilAmounts) {
        int[] goodWorths = {1, 2, 3, 3, 4, 10};
        int[] evilWorths = {1, 2, 2, 2, 3, 5, 10};
        int goodTotal = totalWorth(goodAmounts, goodWorths);
        int evilTotal = totalWorth(evilAmounts, evilWorths);
        if (evilTotal > goodTotal) {
            return "Battle Result: Evil eradicates all trace of Good";
        } else if (evilTotal == goodTotal) {
            return "Battle Result: No victor on this battle field";
        } else {
            return "Battle Result: Good triumphs over Evil";
        }
    }

    private static int totalWorth(final String amounts, final int[] worths) {
        int total = 0;
        String[] splitAmounts = amounts.split(" ");
        for (int i = 0; i < splitAmounts.length; i++) {
            int amount = Integer.parseInt(splitAmounts[i]);
            total += worths[i] * amount;
        }
        return total;
    }
}