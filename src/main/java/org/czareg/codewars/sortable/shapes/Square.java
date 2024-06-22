package org.czareg.codewars.sortable.shapes;

record Square(double side) implements Shape {

    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}