package org.czareg.codewars.herding.cats;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatWeightComparatorTest {

    @Test
    void testSimpleCase() {
        Cat[] cats = new Cat[2];
        cats[0] = new Cat("Lily", 30);
        cats[1] = new Cat("Drake", 15);

        Arrays.sort(cats, new CatWeightComparator());

        assertEquals("Drake", cats[0].name);
        assertEquals("Lily", cats[1].name);
    }

    @Test
    void testWithCatsOfTheSameWeight() {
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Lily", 30);
        cats[1] = new Cat("Drake", 15);
        cats[2] = new Cat("Tails", 10);
        cats[3] = new Cat("Chimbo", 10);

        Arrays.sort(cats, new CatWeightComparator());

        assertEquals("Tails", cats[0].name);
        assertEquals("Chimbo", cats[1].name);
        assertEquals("Drake", cats[2].name);
        assertEquals("Lily", cats[3].name);
    }

    @Test
    void testWithCatOfNegativeWeight() {
        Cat[] cats = new Cat[2];
        cats[0] = new Cat("Void Kitty", -30);
        cats[1] = new Cat("Drake", 15);

        Arrays.sort(cats, new CatWeightComparator());

        assertEquals("Void Kitty", cats[0].name);
        assertEquals("Drake", cats[1].name);
    }

    @Test
    void testWithRandomlyWeightedCats() {
        int length = 100;
        Cat[] cats1 = new Cat[length];
        Cat[] cats2 = new Cat[length];

        Random r = new Random();
        for (int i = 0; i < length; i++) {
            Cat c = new Cat(((Integer) i).toString(), r.nextDouble());
            cats1[i] = c;
            cats2[i] = c;
        }

        Arrays.sort(cats1, new CatWeightComparator());
        Arrays.sort(cats2, (cat1, cat2) -> (int) Math.signum(cat1.weight - cat2.weight));

        for (int i = 0; i < length; i++) {
            assertEquals(cats2[i].name, cats1[i].name);
        }
    }
}