package org.czareg.codewars.sortable.shapes;

record Triangle(double base, double height) implements Shape {

    @Override
    public double area() {
        return (base * height) / 2.0;
    }
}