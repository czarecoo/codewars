package org.czareg.codewars.combine.strings;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCombinerTest {

    @Test
    @Order(1)
    void test1() {
        assertEquals("James Stevens",
                StringCombiner.combineNames("James", "Stevens"));
    }

    @Test
    @Order(2)
    void test2() {
        assertEquals("Spaceman Spiff",
                StringCombiner.combineNames("Spaceman", "Spiff"));
    }

    @Test
    @Order(3)
    void test3() {
        assertEquals("Sherlock Holmes",
                StringCombiner.combineNames("Sherlock", "Holmes"));
    }

    @Test
    @Order(4)
    void randomTests() {
        var rnd = ThreadLocalRandom.current();
        List<String> firstNames = List.of("James", "Mary", "Robert", "Patricia", "John", "Jennifer", "Michael", "Linda", "David", "Elizabeth", "William", "Barbara", "Richard", "Susan", "Joseph", "Jessica", "Thomas", "Sarah", "Christopher", "Karen", "Charles", "Lisa", "Daniel", "Nancy", "Matthew", "Betty", "Anthony", "Sandra", "Mark", "Margaret", "Donald", "Ashley", "Steven", "Kimberly", "Andrew", "Emily", "Paul", "Donna", "Joshua", "Michelle", "Kenneth", "Carol", "Kevin", "Amanda", "Brian", "Melissa", "George", "Deborah", "Timothy", "Stephanie", "Ronald", "Dorothy", "Jason", "Rebecca", "Edward", "Sharon", "Jeffrey", "Laura", "Ryan", "Cynthia", "Jacob", "Amy", "Gary", "Kathleen", "Nicholas", "Angela", "Eric", "Shirley", "Jonathan", "Brenda", "Stephen", "Emma", "Larry", "Anna", "Justin", "Pamela", "Scott", "Nicole", "Brandon", "Samantha", "Benjamin", "Katherine", "Samuel", "Christine", "Gregory", "Helen", "Alexander", "Debra", "Patrick", "Rachel", "Frank", "Carolyn", "Raymond", "Janet", "Jack", "Maria", "Dennis", "Catherine", "Jerry", "Heather", "Tyler", "Diane", "Aaron", "Olivia", "Jose", "Julie", "Adam", "Joyce", "Nathan", "Victoria", "Henry", "Ruth", "Zachary", "Virginia", "Douglas", "Lauren", "Peter", "Kelly", "Kyle", "Christina", "Noah", "Joan", "Ethan", "Evelyn", "Jeremy", "Judith", "Walter", "Andrea", "Christian", "Hannah", "Keith", "Megan", "Roger", "Cheryl", "Terry", "Jacqueline", "Austin", "Martha", "Sean", "Madison", "Gerald", "Teresa", "Carl", "Gloria", "Harold", "Sara", "Dylan", "Janice", "Arthur", "Ann", "Lawrence", "Kathryn", "Jordan", "Abigail", "Jesse", "Sophia", "Bryan", "Frances", "Billy", "Jean", "Bruce", "Alice", "Gabriel", "Judy", "Joe", "Isabella", "Logan", "Julia", "Alan", "Grace", "Juan", "Amber", "Albert", "Denise", "Willie", "Danielle", "Elijah", "Marilyn", "Wayne", "Beverly", "Randy", "Charlotte", "Vincent", "Natalie", "Mason", "Theresa", "Roy", "Diana", "Ralph", "Brittany", "Bobby", "Doris", "Russell", "Kayla", "Bradley", "Alexis", "Philip", "Lori", "Eugene", "Marie");
        List<String> lastNames = List.of("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James", "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz", "Hayes");
        for (int run = 0; run < 100; ++run) {
            String first = firstNames.get(rnd.nextInt(firstNames.size()));
            String last = lastNames.get(rnd.nextInt(lastNames.size()));
            String expected = first + " " + last;
            assertEquals(expected, StringCombiner.combineNames(first, last));
        }
    }
}