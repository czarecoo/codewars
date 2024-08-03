package org.czareg.codewars.index.of.an.element.in.an.array;

import lombok.experimental.UtilityClass;

/*
Be Concise IV - Index of an element in an array
Provided is a function Kata which accepts two parameters in the following order: array, element and
returns the index of the element if found and "Not found" otherwise. Your task is to shorten the code as much as possible
in order to meet the strict character count requirements of the Kata. (no more than 161) You may assume that all array elements are unique.
 */
@UtilityClass
public class IndexFinder {

    public static String find(String[] a, String s) {
        int i = java.util.List.of(a).indexOf(s);
        return i < 0 ? "Not found" : i + "";
    }
}
/* SMALLEST POSSIBLE
class Solution{static String kata(String[]a, String s){int i=java.util.List.of(a).indexOf(s);return i<0?"Not found":i+"";}}
 */