package org.czareg.codewars.approaching.enemies;

import lombok.experimental.UtilityClass;

/*
You are in a military mission in the middle of the jungle where your enemies are really hard to spot because of their camouflage. Luckily you have a device that shows the position of your enemies!

Your device is a radar that computes the x and y coordinates of an enemy in meters every 5 seconds. You are always at the point (0, 0) and your enemies are always heading towards you.

Your task
The radar will give you two consecutive points P1(x, y) and P2(x, y) of an enemy and you should write a function that will return the estimated time in seconds that the enemy will take to reach you, so you can defend! Python results should be rounded to 3 decimal places.

Hints
Distance between two points. Remember that you are working with only 2 dimensions!

Tests will have a precision of 3 decimal points. Good luck!
 */
@UtilityClass
public class Radar {

    public static double calculateTime(double[] p1, double[] p2) {
        Point point1 = Point.of(p1);
        Point point2 = Point.of(p2);
        double distancePer5 = Point.calculateDistance(point1, point2);
        double distanceLeft = Point.calculateDistance(point2, Point.START);
        return distanceLeft / distancePer5 * 5;
    }

    record Point(double x, double y) {
        static final Point START = new Point(0, 0);

        static Point of(double[] point) {
            if (point.length != 2) {
                throw new IllegalArgumentException();
            }
            return new Point(point[0], point[1]);
        }

        static double calculateDistance(Point p1, Point p2) {
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        }
    }
}
