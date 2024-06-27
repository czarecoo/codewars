package org.czareg.codewars.fruit.machine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FruitMachineTest {

    @Test
    void fixedTests() {
        assertEquals(
                50,
                FruitMachine.fruit(new String[][]{new String[]{"Wild", "Star", "Bell", "Shell", "Seven",
                                "Cherry", "Bar", "King", "Queen", "Jack"},
                                new String[]{"Wild", "Star", "Bell", "Shell", "Seven",
                                        "Cherry", "Bar", "King", "Queen", "Jack"},
                                new String[]{"Wild", "Star", "Bell", "Shell", "Seven",
                                        "Cherry", "Bar", "King", "Queen", "Jack"}},
                        new int[]{5, 5, 5}));

        assertEquals(
                100,
                FruitMachine.fruit(new String[][]{new String[]{"Wild", "Star", "Bell", "Shell", "Seven",
                                "Cherry", "Bar", "King", "Queen", "Jack"},
                                new String[]{"Bar", "Wild", "Queen", "Bell", "King",
                                        "Seven", "Cherry", "Jack", "Star", "Shell"},
                                new String[]{"Bell", "King", "Wild", "Bar", "Seven",
                                        "Jack", "Shell", "Cherry", "Queen", "Star"}},
                        new int[]{0, 1, 2}));

        assertEquals(
                10,
                FruitMachine.fruit(new String[][]{new String[]{"King", "Cherry", "Bar", "Jack", "Seven",
                                "Queen", "Star", "Shell", "Bell", "Wild"},
                                new String[]{"Bell", "Seven", "Jack", "Queen", "Bar",
                                        "Star", "Shell", "Wild", "Cherry", "King"},
                                new String[]{"Wild", "King", "Queen", "Seven", "Star",
                                        "Bar", "Shell", "Cherry", "Jack", "Bell"}},
                        new int[]{9, 8, 7}));

        assertEquals(
                6,
                FruitMachine.fruit(new String[][]{new String[]{"King", "Jack", "Wild", "Bell", "Star",
                                "Seven", "Queen", "Cherry", "Shell", "Bar"},
                                new String[]{"Star", "Bar", "Jack", "Seven", "Queen",
                                        "Wild", "King", "Bell", "Cherry", "Shell"},
                                new String[]{"King", "Bell", "Jack", "Shell", "Star",
                                        "Cherry", "Queen", "Bar", "Wild", "Seven"}},
                        new int[]{0, 5, 0}));

        assertEquals(
                10,
                FruitMachine.fruit(new String[][]{new String[]{"Bell", "Wild", "Queen", "Jack", "Shell",
                                "Cherry", "King", "Seven", "Bar", "Star"},
                                new String[]{"Queen", "Shell", "Jack", "Star", "Wild",
                                        "Cherry", "Seven", "Bell", "Bar", "King"},
                                new String[]{"Shell", "Wild", "Queen", "Jack", "Seven",
                                        "King", "Bell", "Bar", "Star", "Cherry"}},
                        new int[]{3, 4, 1}));
    }

    private int randomIndex(int range) {
        return (int) (Math.random() * range);
    }

    private void shuffle(String[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = randomIndex(a.length);
            String t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    private static final String[] templateReel = new String[]{"Wild", "Star", "Bell", "Shell", "Seven",
            "Cherry", "Bar", "King", "Queen", "Jack"};

    @Test
    void randomTests() {
        String[][] reels = new String[3][];
        int[] spins = new int[3];
        for (int i = 0; i < reels.length; i++) {
            reels[i] = new String[templateReel.length];
            System.arraycopy(templateReel, 0, reels[i], 0, templateReel.length);
        }
        for (int trial = 1; trial <= 100; trial++) {
            for (int i = 0; i < reels.length; i++) {
                shuffle(reels[i]);
                spins[i] = randomIndex(reels[i].length);
            }
            assertEquals(solution(reels, spins), FruitMachine.fruit(reels, spins));
        }
    }

    private static int solution(final String[][] reels, final int[] spins) {
        String item = "", extra = "";
        String[] items = new String[]{reels[0][spins[0]],
                reels[1][spins[1]],
                reels[2][spins[2]]};
        if (items[0].equals(items[1]) && items[0].equals(items[2])) {
            for (int i = 0; i < templateReel.length; i++) {
                if (templateReel[i].equals(items[0])) {
                    return (10 - i) * 10;
                }
            }
        }
        if (items[0].equals(items[1])) {
            item = items[0];
            extra = items[2];
        }
        if (items[0].equals(items[2])) {
            item = items[0];
            extra = items[1];
        }
        if (items[1].equals(items[2])) {
            item = items[1];
            extra = items[0];
        }
        if (!item.isEmpty()) {
            for (int i = 0; i < templateReel.length; i++) {
                if (templateReel[i].equals(item)) {
                    return (10 - i) * (extra.equals("Wild") ? 2 : 1);
                }
            }
        }
        return 0;
    }
}