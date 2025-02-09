package org.czareg.codewars.find.single.non.duplicate.number;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
You are given a sorted array nums where every element appears exactly twice, except for one element which appears only once.
Your task is to return the single non-duplicate element in O(log n) time.

Example Test Cases:
Input: [1,1,2,3,3,4,4,8,8] | Expected Output: 2
Input: [3,3,7,7,10,11,11] | Expected Output: 10
Input: [1,1,2,2,3] | Expected Output: 3

Constraints:
1 ≤ |nums| ≤ 10^5 (always odd length).
Each number appears exactly twice, except for one unique number.
The array is sorted in non-decreasing order.
Your solution must run in O(log n) time complexity.
 */
@UtilityClass
public class FindTheSingleNonDuplicateNumber {

    public int singleNonDuplicate(ArrayList<Integer> nums) {
        return ForkJoinPool.commonPool().invoke(new CustomRecursiveTask(nums));
    }

    public class CustomRecursiveTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 1000;

        private List<Integer> list;

        public CustomRecursiveTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Integer compute() {
            if (list.size() >= THRESHOLD) {
                return ForkJoinTask.invokeAll(createSubtasks())
                        .stream()
                        .map(ForkJoinTask::join)
                        .filter(Objects::nonNull)
                        .findAny()
                        .orElseThrow();
            } else {
                return processing(list);
            }
        }

        private Collection<CustomRecursiveTask> createSubtasks() {
            List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
            int middleIndex = (list.size() + 1) / 2;
            dividedTasks.add(new CustomRecursiveTask(list.subList(0, middleIndex)));
            dividedTasks.add(new CustomRecursiveTask(list.subList(middleIndex, list.size())));
            return dividedTasks;
        }

        private Integer processing(List<Integer> list) {
            if (list.isEmpty()) {
                return null;
            }
            if (list.size() == 1) {
                return list.getFirst();
            }
            for (int i = 1; i < list.size(); i += 2) {
                Integer prev = list.get(i - 1);
                Integer curr = list.get(i);
                if (!prev.equals(curr)) {
                    return prev;
                }
            }
            Integer preLast = list.get(list.size() - 2);
            Integer last = list.getLast();
            if (!preLast.equals(last)) {
                return last;
            }
            return null;
        }
    }
}
