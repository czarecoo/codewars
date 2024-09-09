package org.czareg.codewars.atm;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/*
An ATM ran out of 10 dollar bills and only has 100, 50 and 20 dollar bills.

Given an amount between 40 and 10000 dollars (inclusive) and assuming that the ATM wants to use as few bills as possible, determinate the minimal number of 100, 50 and 20 dollar bills the ATM needs to dispense (in that order).

Example
For n = 250, the result should be [2, 1, 0].
For n = 260, the result should be [2, 0, 3].
For n = 370, the result should be [3, 1, 1].

Input/Output
[input] integer n Amount of money to withdraw. Assume that n is always exchangeable with [100, 50, 20] bills.
[output] integer array An array of number of 100, 50 and 20 dollar bills needed to complete the withdraw (in that order).
 */
@UtilityClass
class Atm {

    private static final Map<Integer, int[]> RESULTS = new HashMap<>();

    static {
        RESULTS.put(40, new int[]{0, 0, 2});
        RESULTS.put(50, new int[]{0, 1, 0});
        RESULTS.put(60, new int[]{0, 0, 3});
        RESULTS.put(70, new int[]{0, 1, 1});
        RESULTS.put(80, new int[]{0, 0, 4});
        RESULTS.put(90, new int[]{0, 1, 2});
        RESULTS.put(100, new int[]{1, 0, 0});
        RESULTS.put(110, new int[]{0, 1, 3});
        RESULTS.put(120, new int[]{1, 0, 1});
        RESULTS.put(130, new int[]{0, 1, 4});
    }

    static int[] withdraw(int n) {
        if (RESULTS.containsKey(n)) {
            return RESULTS.get(n);
        }
        int howManyHundreds = n / 100;
        for (int i = howManyHundreds; i >= 0; i--) {
            int reminder = n - i * 100;
            if (RESULTS.containsKey(reminder)) {
                int[] reminderResult = RESULTS.get(reminder);
                return new int[]{reminderResult[0] + i, reminderResult[1], reminderResult[2]};
            }
        }
        throw new IllegalArgumentException();
    }
}

