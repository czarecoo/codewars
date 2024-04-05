package org.czareg.codewars.how.many.smaller;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SmallerTest {

    @Test
    void initialTests() {
        assertArrayEquals(new int[]{4, 3, 2, 1, 0}, Smaller.smaller(new int[]{5, 4, 3, 2, 1}));
        assertArrayEquals(new int[]{0, 0, 0}, Smaller.smaller(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 1, 0}, Smaller.smaller(new int[]{1, 2, 0}));
        assertArrayEquals(new int[]{0, 1, 0}, Smaller.smaller(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{3, 3, 0, 0, 0}, Smaller.smaller(new int[]{1, 1, -1, 0, 0}));
        assertArrayEquals(new int[]{4, 1, 5, 5, 0, 0, 0, 0, 0}, Smaller.smaller(new int[]{5, 4, 7, 9, 2, 4, 4, 5, 6}));
        assertArrayEquals(new int[]{5, 2, 6, 6, 1, 1, 0, 0, 0, 0}, Smaller.smaller(new int[]{5, 4, 7, 9, 2, 4, 1, 4, 5, 6}));
    }

    @Test
    void mediumSizedTests() {
        for (int i = 0; i < 100; i++) {
            int[] mediumArray = randomArray(false);
            assertArrayEquals(Node.solution(mediumArray), Smaller.smaller(mediumArray));
        }
    }

    @Test
    void bigSizedTests() {
        for (int i = 0; i < 100; i++) {
            int[] bigArray = randomArray(true);
            assertArrayEquals(Node.solution(bigArray), Smaller.smaller(bigArray));
        }
    }

    private int[] randomArray(boolean isBig) {
        Random random = new Random();
        int size = 80 + random.nextInt(20);
        int maxValue = 200;
        if (isBig) {
            size = 80000 + random.nextInt(20000);
            maxValue = 5000;
        }
        int[] randomArray = new int[size];
        for (int y = 0; y < size; y++) {
            randomArray[y] = random.nextInt(maxValue);
        }
        return randomArray;
    }

    private static class Node {

        private int occurrences;
        private final int value;
        private int lefties;
        private Node left;
        private Node right;

        private Node(int x) {
            occurrences = 1;
            lefties = 0;
            value = x;
            left = null;
            right = null;
        }

        public static int[] solution(int[] unsorted) {
            int[] answer = new int[unsorted.length];
            Node root = new Node(unsorted[unsorted.length - 1]);
            answer[answer.length - 1] = 0;
            for (int x = unsorted.length - 2; x >= 0; x--) {
                Node runningnode = root;
                int totallefties = 0;
                while (runningnode != null) {
                    if (unsorted[x] < runningnode.value) {
                        if (runningnode.left == null) {
                            runningnode.left = new Node(unsorted[x]);
                            runningnode.lefties++;
                            runningnode = null;
                            answer[x] = totallefties;
                        } else {
                            runningnode.lefties++;
                            runningnode = runningnode.left;
                        }
                    } else if (unsorted[x] > runningnode.value) {
                        if (runningnode.right == null) {
                            runningnode.right = new Node(unsorted[x]);
                            answer[x] = totallefties + runningnode.lefties + runningnode.occurrences;
                            runningnode = null;
                        } else {
                            totallefties = totallefties + runningnode.lefties + runningnode.occurrences;
                            runningnode = runningnode.right;
                        }
                    } else {
                        runningnode.occurrences++;
                        answer[x] = totallefties + runningnode.lefties;
                        runningnode = null;
                    }
                }
            }
            return answer;
        }
    }
}