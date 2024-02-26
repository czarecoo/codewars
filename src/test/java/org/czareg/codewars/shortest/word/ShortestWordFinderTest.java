package org.czareg.codewars.shortest.word;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestWordFinderTest {

    @Test
    void findShort() {
        assertEquals(3, ShortestWordFinder.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, ShortestWordFinder.findShort("turns out random test cases are easier than writing out basic ones"));

        assertEquals(3, ShortestWordFinder.findShort("lets talk about Java the best language"));
        assertEquals(1, ShortestWordFinder.findShort("i want to travel the world writing code one day"));
        assertEquals(2, ShortestWordFinder.findShort("Lets all go on holiday somewhere very cold"));
        assertEquals(2, ShortestWordFinder.findShort("Let's travel abroad shall we"));
    }

    private int sol(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().orElseThrow();
    }

    private static final String[] names = {"Bitcoin", "LiteCoin", "Ripple", "Dash", "Lisk", "DarkCoin", "Monero", "Ethereum", "Classic", "Mine", "ProofOfWork", "ProofOfStake", "21inc", "Steem", "Dogecoin", "Waves", "Factom", "MadeSafeCoin", "BTC"};

    @Test
    void randomTests() {
        Random r = new Random();
        for (int run = 0; run < 20; ++run) {
            int skip = r.nextInt(13);
            String[] n = Arrays.stream(names).filter(x -> x.length() >= skip).toArray(String[]::new);
            Collections.shuffle(Arrays.asList(n), r);
            String a = String.join(" ", n);
            assertEquals(sol(a), ShortestWordFinder.findShort(a), "For string \"" + a + "\"");
        }
    }
}