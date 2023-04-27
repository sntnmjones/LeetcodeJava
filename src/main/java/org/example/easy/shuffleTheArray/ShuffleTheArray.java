package org.example.easy.shuffleTheArray;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 * <p>
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * <p>
 * Constraints:
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
public class ShuffleTheArray {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test(new int[]{2, 5, 1, 3, 4, 7}, 3, new int[]{2, 3, 5, 4, 1, 7})
        );

        List<String> testMethodNames = Arrays.asList("bruteForce");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, int[].class, int.class, ShuffleTheArray.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new ShuffleTheArray());
    }

    /**
     * See pdf for explanation
     * <p>
     * Runtime: O(n)
     * Space Complexity: O(n)
     * <p>
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 43.1 MB
     * Beats
     * 8.21%
     */
    protected int[] bruteForce(int[] nums, int n) {
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }

        return result;
    }
}
