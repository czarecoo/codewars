package org.czareg.codewars.longest.mountain.pass;

import lombok.experimental.UtilityClass;

/*
You are an adventurous hiker planning to traverse a mountain range. The mountain range is represented by an array of integers,
where each element corresponds to the height of a mountain at that position.
Your goal is to find the longest mountain pass you can take based on your initial energy level.

Problem Description
You are given an array of mountains, where each element represents the height of the mountain.
A mountain pass is defined as a subarray of the mountain array. The length of a mountain pass is the length of the subarray.
You have an initial energy level E.
You start at any initial index of your choice.
Going up a mountain (i.e., moving from a lower height to a higher height) costs you energy equal to the difference in heights.
Going down a mountain or staying at the same height does not cost you any energy.
You can only move to the mountains on your right (i.e., the next index).
Your task is to find the longest mountain pass you can take based on your initial energy level.
Return the length of the longest mountain pass and the initial index from where you should start.

Input
mountains: An array of integers representing the heights of the mountains.
E: An integer representing your initial energy level.
Note: The length of the mountain array can be very large, up to 10^7.

Output
Return a tuple (max_length, start_index), where:

max_length: The length of the longest mountain pass you can take.
start_index: The initial index from where you should start the mountain pass.
If there are multiple mountain passes with the same length, return the one with the smallest initial index.
 */
@UtilityClass
class LongestMountainPassCalculator {

    static Result calculate(int[] mountains, int initialEnergyLevel) {
        int maxLength = 0;
        int startIdx = 0;

        for (int i = 0; i < mountains.length; i++) {
            int energy = initialEnergyLevel;
            int length = 1;
            int j = i;
            while (j < mountains.length - 1) {
                int cost = mountains[j + 1] - mountains[j];
                if (cost <= 0 || energy >= cost) {
                    if (cost > 0) {
                        energy -= cost;
                    }
                    j++;
                    length++;
                } else {
                    break;
                }
            }
            if (length > maxLength) {
                maxLength = length;
                startIdx = i;
            }
        }

        return new Result(maxLength, startIdx);
    }
}
