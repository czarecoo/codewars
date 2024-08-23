package org.czareg.codewars.supermarket.queue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupermarketQueueTest {

    @Test
    @Order(1)
    void normalCondition() {
        assertEquals(9, SupermarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2), "For customers {2, 2, 3, 3, 4, 4} and 2 tills");
    }

    @Test
    @Order(2)
    void emptyWaitingQueue() {
        assertEquals(0, SupermarketQueue.solveSuperMarketQueue(new int[]{}, 1), "For no customers and 1 till");
    }

    @Test
    @Order(3)
    void bigN() {
        assertEquals(5, SupermarketQueue.solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 100), "For customers {1, 2, 3, 4, 5} and 100 tills");
    }

    @Test
    @Order(4)
    void singleCustomer() {
        assertEquals(2, SupermarketQueue.solveSuperMarketQueue(new int[]{2}, 5), "For customers {2} and 5 tills");
    }

    @Test
    @Order(5)
    void singleCustomerSingleTill() {
        assertEquals(5, SupermarketQueue.solveSuperMarketQueue(new int[]{5}, 1), "For customers {5} and 1 till");
    }

    @Test
    @Order(6)
    void singleTillManyCustomers() {
        assertEquals(15, SupermarketQueue.solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 1), "For customers {1, 2, 3, 4, 5} and 1 till");
    }

    @Test
    @Order(7)
    void longCustomerQueue() {
        assertEquals(113, SupermarketQueue.solveSuperMarketQueue(new int[]{29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22, 20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26, 7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4}, 7),
                "For customers {29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22, 20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26, 7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4} and 7 tills");
    }

    @Test
    @Order(999)
    void randomTests() {
        final int max_tills = 6;
        var rand = ThreadLocalRandom.current();
        for (int runs = 0; runs < 100; runs++) {
            int n = rand.nextInt(max_tills) + 1;
            int[] queue = generateRandomArray();
            for (int j = 0; j < 3; j++) {
                n = ((n + j) % max_tills) + 1;
                assertEquals(refSol(queue, n), SupermarketQueue.solveSuperMarketQueue(queue.clone(), n), "For customers " + Arrays.toString(queue) + " and " + n + " till" + (n == 1 ? "" : "s"));
            }
        }
    }

    private int[] generateRandomArray() {
        var rand = ThreadLocalRandom.current();
        final int max_elements = 25;
        final int max_single_value = 7;
        long size = rand.nextInt(max_elements) + 1;
        return rand.ints(size, 1, max_single_value + 1).toArray();
    }

    private static int getArrayIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == value)
                return i;
        return 0;
    }

    private static int refSol(int[] customers, int n) {
        // I want to be explicit about it
        if (customers.length == 0) {
            return 0;
        }
        int i = n;
        // I want to use primitive int, problems?
        int ssize = Math.min(customers.length, n);
        int[] sample = new int[ssize];
        System.arraycopy(customers, 0, sample, 0, ssize);
        while (i < customers.length) {
            int mmin = Arrays.stream(sample).min().orElseThrow();
            int idx = getArrayIndex(sample, mmin);
            sample[idx] += customers[i];
            i++;
        }
        return Arrays.stream(sample).max().getAsInt();
    }
}