package org.czareg.codewars.who.likes.it;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LikesToTextTest {

    private static final String[] NAMES = new String[]{"Brian", "Marilyn", "Pamela", "Timothy", "Jesse", "Heather", "Terry", "Carlos",
            "Bonnie", "Randy", "Lillian", "Emily", "Louis", "Chris", "Howard", "Helen", "Ralph", "Jennifer", "Mark", "Laura",
            "Jason", "Shirley", "Diane", "Phillip", "David", "Joan", "Wanda", "Jimmy", "Carl", "Betty", "Adam", "Lawrence",
            "Kathleen", "Mildred", "Rose", "Tina", "Jose", "Keith", "Janice", "Maria", "Kenneth", "Arthur", "James", "Catherine",
            "Henry", "Denise", "Ruby", "Cynthia", "Anthony", "Jeffrey", "Eugene", "Dorothy", "Lori", "Bobby", "Peter", "Alice",
            "Eric", "Wayne", "Phyllis", "Roger", "Clarence", "Scott", "John", "Philip", "Teresa", "Andrea", "Douglas", "Earl",
            "Melissa", "Benjamin", "Rebecca", "Michelle", "Alan", "Brenda", "William", "Frank", "Matthew", "George", "Anna",
            "Cheryl", "Roy", "Paula", "Tammy", "Gerald", "Christina", "Russell", "Kelly", "Albert", "Donna", "Todd", "Jessica",
            "Kimberly", "Johnny", "Dennis", "Jack", "Doris", "Martha", "Stephanie", "Stephen", "Christine"};

    @Test
    void staticTests() {
        assertEquals("no one likes this", LikesToText.whoLikesIt());
        assertEquals("Peter likes this", LikesToText.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", LikesToText.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", LikesToText.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", LikesToText.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        assertEquals("Brian, Marilyn and 98 others like this", LikesToText.whoLikesIt(NAMES));
    }

    @Test
    void randomTests() {
        Random rand = new Random();
        for (int i = 0; i < 24; i++) {
            int r = rand.nextInt(100);
            String[] randNames = new String[r];
            for (int j = 0; j < r; j++) randNames[j] = NAMES[rand.nextInt(100)];
            assertEquals(whoLikesIt(randNames), LikesToText.whoLikesIt(randNames));
        }
    }

    private String whoLikesIt(String... names) {
        return switch (names.length) {
            case 0 -> "no one likes this";                //feels bad man
            case 1 -> names[0] + " likes this";
            case 2 -> String.format("%s and %s like this", names[0], names[1]);
            case 3 -> String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default -> String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        };
    }
}