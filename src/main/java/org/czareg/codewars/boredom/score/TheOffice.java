package org.czareg.codewars.boredom.score;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Map;

/*
Every now and then people in the office moves teams or departments.
Depending what people are doing with their time they can become more or less boring. Time to assess the current team.

You will be provided with an array of Person objects with each instance containing the name and department for a staff member.

Each department has a different boredom assessment score, as follows:

accounts = 1
finance = 2
canteen = 10
regulation = 3
trading = 6
change = 6
IS = 8
retail = 5
cleaning = 4
pissing about = 25

Depending on the cumulative score of the team, return the appropriate sentiment:

<=80: 'kill me now'
< 100 & > 80: 'i can handle this'
100 or over: 'party time!!'
 */
@UtilityClass
class TheOffice {

    private static final Map<String, Integer> BOREDOM_SCORE = Map.of(
            "accounts", 1,
            "finance", 2,
            "canteen", 10,
            "regulation", 3,
            "trading", 6,
            "change", 6,
            "IS", 8,
            "retail", 5,
            "cleaning", 4,
            "pissing about", 25
    );

    static String boredom(Person[] staff) {
        int sum = calculateSum(staff);
        return sumToSentiment(sum);
    }

    private static int calculateSum(Person[] staff) {
        return Arrays.stream(staff)
                .map(person -> person.department)
                .mapToInt(department -> BOREDOM_SCORE.getOrDefault(department, 0))
                .sum();
    }

    private static String sumToSentiment(int sum) {
        if (sum <= 80) {
            return "kill me now";
        }
        if (sum >= 100) {
            return "party time!!";
        }
        return "i can handle this";
    }
}
