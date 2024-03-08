package org.czareg.codewars.spider.and.fly;

import lombok.experimental.UtilityClass;

/*
A spider web is defined by
"rings" numbered out from the centre as 0, 1, 2, 3, 4
"radials" labelled clock-wise from the top as A, B, C, D, E, F, G, H

Web Coordinates
As you can see, each point where the rings and the radials intersect can be described by a "web coordinate".

So in this example the spider is at H3 and the fly is at E2

Kata Task
Our friendly jumping spider is resting and minding his own spidery business at web-coordinate spider.

An inattentive fly bumbles into the web at web-coordinate fly and gets itself stuck.

Your task is to calculate and return the distance the spider must jump to get to the fly.

Example
The solution to the scenario described by the picture is 4.63522

Notes
The centre of the web will always be referred to as A0
The rings intersect the radials at evenly spaced distances of 1 unit
 */
@UtilityClass
public class DistanceCalculator {

    private static final String RADIALS = "ABCDEFGH";

    public static double spiderToFly(final String spider, final String fly) {
        if (spider.equals(fly)) {
            return 0d;
        }
        String[] spiderSplit = spider.split("");
        String[] flySplit = fly.split("");
        int spiderRingNo = Integer.parseInt(spiderSplit[1]);
        int flyRingNo = Integer.parseInt(flySplit[1]);
        if (spiderRingNo == 0 && flyRingNo == 0) {
            return 0d;
        }
        String spiderRadial = spiderSplit[0];
        String flyRadial = flySplit[0];
        if (spiderRadial.equals(flyRadial)) {
            return Math.abs(spiderRingNo - flyRingNo);
        }
        int degrees = getDegrees(spiderRadial, flyRadial);
        if (degrees == 180) {
            return (double) spiderRingNo + flyRingNo;
        }
        return Math.sqrt(Math.pow(spiderRingNo, 2) + Math.pow(flyRingNo, 2) - 2 * spiderRingNo * flyRingNo * Math.cos(Math.toRadians(degrees)));
    }

    private static int getDegrees(String radial1, String radial2) {
        return Math.abs(RADIALS.indexOf(radial1) - RADIALS.indexOf(radial2)) * 45;
    }
}
