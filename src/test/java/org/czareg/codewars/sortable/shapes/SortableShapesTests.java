package org.czareg.codewars.sortable.shapes;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortableShapesTests {

    @Test
    void shapesAreSortableOnArea() {
        double area, side, radius, base, height, width;
        List<Shape> expected = new ArrayList<>();

        area = 1.1234;
        expected.add(new Custom(area));

        side = 1.1234;
        expected.add(new Square(side));

        radius = 1.1234;
        expected.add(new Circle(radius));

        height = 2.;
        base = 5.;
        expected.add(new Triangle(base, height));

        height = 3.;
        base = 4.;
        expected.add(new Triangle(base, height));

        width = 4.;
        expected.add(new Rectangle(width, height));

        area = 16.1;
        expected.add(new Custom(area));

        List<Shape> actual = createRandomOrderedList(expected);

        Collections.sort(actual);

        Iterator<Shape> a = actual.iterator();
        for (Shape e : expected) {
            assertEquals(e, a.next());
        }
    }

    @Test
    void randomizedTest() {
        Random random = new Random();
        List<ShapeContainer> expected = new ArrayList<>();
        List<Shape> actual = new ArrayList<>();
        for (int i = 0; i < 25000; i++) {
            Shape shape;
            double area;
            switch (random.nextInt(5)) {
                case 0:
                    double side = random.nextDouble();
                    shape = new Square(side);
                    area = side * side;
                    break;
                case 1:
                    double width = random.nextDouble();
                    double height = random.nextDouble();
                    shape = new Rectangle(width, height);
                    area = width * height;
                    break;
                case 2:
                    double base = random.nextDouble();
                    height = random.nextDouble();
                    shape = new Triangle(base, height);
                    area = (base * height) / 2;
                    break;
                case 3:
                    double radius = random.nextDouble();
                    shape = new Circle(radius);
                    area = (Math.pow(radius, 2) * Math.PI);
                    break;
                default:
                    area = random.nextDouble();
                    shape = new Custom(area);
                    break;
            }
            expected.add(new ShapeContainer(area, shape));
            actual.add(shape);
        }
        expected.sort(new ShapeComparator());

        Collections.sort(actual);

        Iterator<Shape> a = actual.iterator();
        for (ShapeContainer e : expected) {
            assertEquals(e.shape, a.next());
        }
    }

    private static class ShapeContainer {
        public double area;
        public Shape shape;

        public ShapeContainer(double area, Shape shape) {
            this.area = area;
            this.shape = shape;
        }
    }

    private static class ShapeComparator implements Comparator<ShapeContainer> {
        public int compare(ShapeContainer c1, ShapeContainer c2) {
            if (c1.area == c2.area) return 0;
            return c1.area > c2.area ? 1 : -1;
        }
    }

    private List<Shape> createRandomOrderedList(List<Shape> expected) {
        Random random = new Random();
        List<Shape> actual = new ArrayList<>();
        for (Shape shape : expected) {
            int j = random.nextInt(actual.size() + 1);
            actual.add(j, shape);
        }
        return actual;
    }
}