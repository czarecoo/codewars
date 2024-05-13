package org.czareg.codewars.swyply;

record Element(int weight, int value) {

    Element {
        if (weight != 1 && weight != 2) {
            throw new IllegalArgumentException("Weight can only be 1 or 2");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Value should be a non negative integer");
        }
    }
}
