package org.example.easy;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/concatenation-of-array/
 * <p>
 * Given an integer array nums of length n, you want to create an array ans of length 2n where
 * ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * <p>
 * Specifically, ans is the concatenation of two nums arrays.
 * <p>
 * Return the array ans.
 */
public class ConcatenationOfArray {

    public static void main(String[] args) {
        List<Test> tests = Arrays.asList(
                new Test(new int[]{1, 2, 1}, new int[]{1, 2, 1, 1, 2, 1}),
                new Test(new int[]{1, 3, 2, 1}, new int[]{1, 3, 2, 1, 1, 3, 2, 1}),
                new Test(new int[]{1}, new int[]{1, 1})
        );

        for (Test test : tests) {
            long startTime = System.nanoTime();

            int[] result = bruteForce(test.input);

            System.out.println(String.format("%d nano", System.nanoTime() - startTime));
            System.out.println(String.format("Passed test: %s", Arrays.toString(result).equals(Arrays.toString(test.output))));
            System.out.println(Arrays.toString(result));
        }
    }

    /**
     * Iterate through the nums array and copy the current element into the respective spots in the
     * ans array
     * <p>
     * Runtime: O(n)
     * Space: O(n)
     * <p>
     * Runtime
     * 1 ms
     * Beats
     * 93.8%
     * Memory
     * 43.4 MB
     * Beats
     * 27.92%
     */
    private static int[] bruteForce(int[] nums) {
        int numsLength = nums.length;
        int[] ans = new int[numsLength * 2];

        for (int i = 0; i < numsLength; i++) {
            ans[i] = nums[i];
            ans[i + numsLength] = nums[i];
        }

        return ans;
    }

    private static class Test {
        int[] input;
        int[] output;

        Test(int[] input, int[] output) {
            this.input = input;
            this.output = output;
        }
    }
}
