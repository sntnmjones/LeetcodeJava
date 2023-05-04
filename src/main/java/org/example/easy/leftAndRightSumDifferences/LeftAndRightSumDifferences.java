package org.example.easy.leftAndRightSumDifferences;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/left-and-right-sum-differences/
 * <p>
 * Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
 * answer.length == nums.length.
 * answer[i] = |leftSum[i] - rightSum[i]|.
 * Where:
 * leftSum[i] is the sum of elements to the left of the index i in the array nums.
 * If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array nums.
 * If there is no such element, rightSum[i] = 0.
 * Return the array answer.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 */
public class LeftAndRightSumDifferences {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test(new int[]{10, 4, 8, 3}, new int[]{15, 1, 11, 22})
        );

        List<String> testMethodNames = Arrays.asList("bruteForce");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, int[].class, LeftAndRightSumDifferences.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new LeftAndRightSumDifferences());
    }

    /**
     * Runtime: O(n)
     * Space Complexity: O(n)
     * <p>
     * Runtime
     * 2 ms
     * Beats
     * 62.38%
     * Memory
     * 43.3 MB
     * Beats
     * 47.42%
     */
    public int[] bruteForce(int[] nums) {
        int numsLength = nums.length;
        int[] leftSum = new int[numsLength];
        int[] rightSum = new int[numsLength];
        int[] result = new int[numsLength];

        leftSum[0] = 0;
        rightSum[numsLength - 1] = 0;

        // leftSum
        for (int i = 1; i < numsLength; i++) {
            leftSum[i] = nums[i - 1] + leftSum[i - 1];
        }

        // rightSum
        for (int i = numsLength - 2; i >= 0; i--) {
            rightSum[i] = nums[i + 1] + rightSum[i + 1];
        }

        // results
        for (int i = 0; i < numsLength; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return result;
    }
}
