package org.czareg.codewars.trilingual.democracy;

import org.junit.jupiter.api.Test;

import static org.czareg.codewars.trilingual.democracy.TrilingualDemocracy.trilingualDemocracy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrilingualDemocracyTest {

    @Test
    void testExamples() {
        test("FFF", 'F');
        test("IIK", 'K');
        test("DFK", 'I');
    }

    public static void test(String group, char want) {
        assertEquals(want, trilingualDemocracy(group.toCharArray()), group);
    }
}