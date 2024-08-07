package org.czareg.codewars.multiplication.generators;

public class Generator {

    private final int a;
    private int num = 0;

    private Generator(int a) {
        this.a = a;
    }

    public static Generator of(int a) {
        return new Generator(a);
    }

    public String next() {
        ++num;
        return "%d x %d = %d".formatted(a, num, a * num);
    }
}

