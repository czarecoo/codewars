package org.czareg.codewars.complete.binary.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeUtilsTest {

    private static final Random RANDOM = new Random();

    @Test
    void emptyArray() {
        TreeNode expected = null;
        assertEquals(expected, TreeUtils.arrayToTree(arrayFrom()));
    }

    @Test
    void arrayWithSingleElement() {
        TreeNode expected = new TreeNode(7);
        assertEquals(expected, TreeUtils.arrayToTree(arrayFrom(7)));
    }

    @Test
    void arrayWithMultipleElements() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3), new TreeNode(15)), new TreeNode(-4));
        assertEquals(expected, TreeUtils.arrayToTree(arrayFrom(17, 0, -4, 3, 15)));
    }

    @Test
    void randomSmallArray() {
        int[] values = RANDOM.ints(-1000, 1001).limit(13).toArray();
        assertEquals(solution(values), TreeUtils.arrayToTree(values));
    }

    @Test
    void randomBigArray() {
        int[] values = RANDOM.ints(-1000, 1001).limit(234).toArray();
        assertEquals(solution(values), TreeUtils.arrayToTree(values));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }

    private static TreeNode solution(int[] array) {
        if (array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        for (int i = 0; !queue.isEmpty(); i++) {
            TreeNode node = queue.remove();
            node.left = nodeFromIndex(array, 2 * i + 1);
            if (node.left != null) {
                queue.add(node.left);
            }
            node.right = nodeFromIndex(array, 2 * i + 2);
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    private static TreeNode nodeFromIndex(int[] array, int index) {
        if (array.length <= index) {
            return null;
        } else {
            return new TreeNode(array[index]);
        }
    }
}