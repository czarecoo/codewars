package org.czareg.codewars.one.eighthundred;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DinglemouseTest {

    @Test
    void example() {
        final Set<String> expected = new HashSet<>();
        expected.add("1-800-CODE-WAR");
        expected.add("1-800-CODE-YAP");
        expected.add("1-800-CODE-WAS");
        expected.add("1-800-CODE-ZAP");
        assertEquals(expected, Dinglemouse.check1800("1-800-CODE-WAR"));
    }
}