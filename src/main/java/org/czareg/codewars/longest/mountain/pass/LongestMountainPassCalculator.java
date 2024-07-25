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


    /*
    Sliding Window: The end pointer expands the window by moving right. For each position, compute the energy cost of moving to the next mountain.
    Energy Management: If energy becomes negative, move the slidingWindowStartIndex to the right until the energy is non-negative again.
    Length Calculation: The length of the current valid window is updated, and if it’s the longest found so far, update longestMountainPass and startIndexOfLongestMountainPass.
    This approach ensures that each mountain is processed in constant time, leading to an overall time complexity of O(n).
    */
    static Result calculate(int[] mountains, int initialEnergyLevel) {
        int longestMountainPass = 0;
        int startIndexOfLongestMountainPass = 0;

        int slidingWindowStartIndex = 0;
        int energy = initialEnergyLevel;
        for (int slidingWindowEndIndex = 0; slidingWindowEndIndex < mountains.length; slidingWindowEndIndex++) {
            // Calculate the cost to move from the previous mountain to the current one
            if (slidingWindowEndIndex > 0) {
                int cost = mountains[slidingWindowEndIndex] - mountains[slidingWindowEndIndex - 1];
                if (cost > 0) {
                    energy -= cost;
                }
            }

            // While energy is negative, move start index to the right and adjust energy
            while (energy < 0) {
                if (slidingWindowStartIndex < slidingWindowEndIndex) {
                    int startCost = mountains[slidingWindowStartIndex + 1] - mountains[slidingWindowStartIndex];
                    if (startCost > 0) {
                        energy += startCost;
                    }
                    slidingWindowStartIndex++;
                } else {
                    // If start catches up with end, break the loop
                    break;
                }
            }

            // Calculate current length of the window
            int currentLength = slidingWindowEndIndex - slidingWindowStartIndex + 1;

            // Update new result
            if (currentLength > longestMountainPass) {
                longestMountainPass = currentLength;
                startIndexOfLongestMountainPass = slidingWindowStartIndex;
            }
        }

        return new Result(longestMountainPass, startIndexOfLongestMountainPass);
    }
}
