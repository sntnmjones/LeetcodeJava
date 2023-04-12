package org.example.easy;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/build-array-from-permutation/
 * <p>
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where
 * ans[i] = nums[nums[i]]
 * for each 0 <= i < nums.length and return it.
 * <p>
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 */
public class BuildArrayFromPermutation {

    public static void main(String[] args) {

        List<Test> tests = Arrays.asList(
                new Test(new int[]{0, 2, 1, 5, 3, 4}, new int[]{0, 1, 2, 4, 5, 3}),
                new Test(new int[]{5, 0, 1, 2, 3, 4}, new int[]{4, 5, 0, 1, 2, 3})
        );

        for (BuildArrayFromPermutation.Test test : tests) {
            long startTime = System.nanoTime();
            int[] result = bruteForce(test.input);
            System.out.println(String.format("%d nano", System.nanoTime() - startTime));
            System.out.println(Arrays.toString(result).equals(Arrays.toString(test.answer)));
            System.out.println(Arrays.toString(result));
        }
    }

    /**
     * Runtime
     * 1 ms
     * Beats
     * 97.61%
     * Memory
     * 43.1 MB
     * Beats
     * 71.73%
     */
    private static int[] bruteForce(int[] nums) {
        int numsLength = nums.length;
        int[] ans = new int[numsLength];

        for (int i = 0; i < numsLength; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    private static class Test {
        int[] input;
        int[] answer;

        Test(int[] input, int[] answer) {
            this.input = input;
            this.answer = answer;
        }
    }
}
