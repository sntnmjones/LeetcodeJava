package org.example.easy.numberOfGoodPairs;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 * <p>
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test(new int[]{1, 2, 3, 1, 1, 3}, 4),
                new Test(new int[]{1, 1, 1, 1}, 6),
                new Test(new int[]{1, 2, 3}, 0)
        );

        List<String> testMethodNames = Arrays.asList("bruteForce");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, int[].class, NumberOfGoodPairs.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new NumberOfGoodPairs());
    }

    /**
     * Runtime: O(n^2)
     * Space Complexity: O(1)
     * <p>
     * Runtime
     * 1 ms
     * Beats
     * 84.41%
     * Memory
     * 40.3 MB
     * Beats
     * 39.80%
     */
    public int bruteForce(int[] nums) {
        int numsLength = nums.length;
        int goodPairs = 0;

        for (int i = 0; i < numsLength; i++) {
            for (int j = (i + 1); j < numsLength; j++) {
                if (nums[i] == nums[j]) {
                    goodPairs++;
                }
            }
        }

        return goodPairs;
    }
}
