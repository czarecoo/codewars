package org.czareg.codewars.complete.binary.tree;

import lombok.experimental.UtilityClass;

/*
You are given an array of integers. Implement a function which creates a complete binary tree from the array (complete meaning that every level of the tree, except possibly the last, is completely filled).

The elements of the array are to be taken left-to-right, and put into the tree top-to-bottom, left-to-right.

For example, given the array [17, 0, -4, 3, 15] you should create the following tree:

    17
   /  \
  0   -4
 / \
3   15
 */
@UtilityClass
public class TreeUtils {

    static TreeNode arrayToTree(int[] array) {
        return constructTree(array, 0);
    }

    static TreeNode constructTree(int[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        TreeNode left = constructTree(array, 2 * index + 1);
        TreeNode right = constructTree(array, 2 * index + 2);
        return new TreeNode(array[index], left, right);
    }
}
