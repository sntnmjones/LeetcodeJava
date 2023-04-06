package org.example.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        List<Test> tests = Arrays.asList(
                new Test(new int[]{2,7,11,15}, new int[]{0,1}, 9),
                new Test(new int[]{3,2,4}, new int[]{1,2}, 6),
                new Test(new int[]{3,3}, new int[]{0,1}, 6)
        );

        for (Test test : tests) {
            long startTime = System.nanoTime();
            int[] result = twoSumImproved(test.input, test.target);
            System.out.println(String.format("%d nano", System.nanoTime() - startTime));
            System.out.println(Arrays.toString(result).equals(Arrays.toString(test.answer)));
            System.out.println(Arrays.toString(result));
        }
    }

    /**
     * O(n)
     * Iterates through the array, storing the value and index in a Map.
     * Performs lookup on the map to see if the difference is found.
     *
     * Runtime
     * 2 ms
     * Beats
     * 81.94%
     * Memory
     * 42.9 MB
     * Beats
     * 39.90%
     */
    private static int[] twoSumImproved(int[] nums, int target) {
        int numsLength = nums.length;
        // value, index
        Map<Integer, Integer> lookupTable = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < numsLength; i++) {
            int difference = target - nums[i];

            // If the number is in the table, get the index and return answer
            if (i > 0 && lookupTable.containsKey(difference)) {
                answer[0] = lookupTable.get(difference);
                answer[1] = i;
                break;
            }

            lookupTable.put(nums[i], i);
        }

        return answer;
    }

    /**
     * O(n*n)
     * Intuitive solution that looks at the current number and looks at each successive number, looking for target
     *
     * Runtime
     * 97 ms
     * Beats
     * 8%
     * Memory
     * 42.7 MB
     * Beats
     * 48.43%
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {
        int inputLength = nums.length;
        Set<Integer> answers = new HashSet<>();
        for (int i = 0; i < inputLength; i++) {
            for (int j = i + 1; j < inputLength; j++) {
                if (nums[i] + nums[j] == target) {
                    answers.add(i);
                    answers.add(j);
                }
            }
        }

        int answersSize = answers.size();
        Object[] answersObjects = answers.toArray();
        int[] answerArray = new int[answersSize];

        for (int j = 0; j < answersSize; j++) {
            answerArray[j] = ((Integer) answersObjects[j]).intValue();
        }

        return answerArray;
    }

    private static class Test {
        int[] input;
        int[] answer;
        int target;

        Test(
                int[] input,
                int[] answer,
                int target
        ) {
            this.input = input;
            this.answer = answer;
            this.target = target;
        }
    }
}
