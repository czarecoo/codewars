package org.czareg.codewars.multiplication.generators;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratorTest {

    @Test
    void next() {
        Generator gen = Generator.of(1);
        assertEquals("1 x 1 = 1", gen.next());
        assertEquals("1 x 2 = 2", gen.next());
        assertEquals("1 x 3 = 3", gen.next());
        assertEquals("1 x 4 = 4", gen.next());
        assertEquals("1 x 5 = 5", gen.next());
    }

    @Test
    void random() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(10000000);
            int num = 0;
            int n = r.nextInt(1000);
            Generator gen = Generator.of(a);
            for (int iteration = 0; iteration < n; iteration++) {
                assertEquals(String.format("%d x %d = %d", a, ++num, a * num), gen.next());
            }
        }
    }
}