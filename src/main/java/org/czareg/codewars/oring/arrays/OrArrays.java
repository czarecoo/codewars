package org.czareg.codewars.oring.arrays;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
It started as a discussion with a friend, who didn't fully grasp some way of setting defaults, but I thought the idea
was cool enough for a beginner kata: binary OR each matching element of two given arrays of integers and give the
resulting ORed array [starts to sound like a tonguetwister, doesn't it?].

If one array is shorter than the other, use the optional third parameter (defaulted to 0) to OR the unmatched elements.

For example:

orArrays([1,2,3],[1,2,3]) == [1,2,3]
orArrays([1,2,3],[4,5,6]) == [5,7,7]
orArrays([1,2,3],[1,2]) == [1,2,3]
orArrays([1,2],[1,2,3]) == [1,2,3]
orArrays([1,2,3],[1,2,3],3) == [1,2,3]
 */
@UtilityClass
public class OrArrays {

    public static int[] orArrays(int[] arr1, int[] arr2) {
        return orArrays(arr1, arr2, 0);
    }

    public static int[] orArrays(int[] arr1, int[] arr2, int def) {
        int max = Math.max(arr1.length, arr2.length);
        IntStream.Builder builder = IntStream.builder();
        for (int i = 0; i < max; i++) {
            int first = getOrDefault(arr1, i, def);
            int second = getOrDefault(arr2, i, def);
            builder.accept(first | second);
        }
        return builder.build().toArray();
    }

    private static int getOrDefault(int[] arr, int index, int def) {
        return index < arr.length ? arr[index] : def;
    }
}
