package org.czareg.codewars.sortable.shapes;

record Rectangle(double width, double height) implements Shape {

    @Override
    public double area() {
        return width * height;
    }
}