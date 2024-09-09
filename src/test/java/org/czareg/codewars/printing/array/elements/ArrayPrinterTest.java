package org.czareg.codewars.printing.array.elements;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayPrinterTest {

    @Test
    @DisplayName("Test strings")
    @Order(1)
    void testString() {
        String[] array = new String[]{"2", "4", "5", "2"};
        assertEquals("2,4,5,2", ArrayPrinter.printArray(array), "Testing with: [\"2\", \"4\", \"5\", \"2\"]");
    }

    @Test
    @DisplayName("Test integers")
    @Order(2)
    void testInteger() {
        Integer[] array = new Integer[]{2, 4, 5, 2};
        assertEquals("2,4,5,2", ArrayPrinter.printArray(array), "Testing with: [2, 4, 5, 2]");
    }

    @TestFactory
    @DisplayName("Random tests")
    @Order(3)
    Iterable<DynamicTest> testRandom() {
        Random rand = new Random();
        List<DynamicTest> tests = new ArrayList<>();
        for (int k = 0; k < 100; k++) {
            int len = rand.nextInt(1, 21);
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                li.add(rand.nextInt(0, 10));
            }

            String expected = solver(li.toArray());

            tests.add(DynamicTest.dynamicTest(String.format("Testing with: %s", li), () -> assertEquals(expected, ArrayPrinter.printArray(li.toArray()))));

        }
        return tests;
    }

    private String solver(Object[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}