package org.example.medium.partitioningIntoMinimumNumberOfDeciBinaryNumbers;

import org.example.easy.BuildArrayFromPermutation;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 * <p>
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 *
 * Constraints:
 * 1 <= n.length <= 10^5
 * n consists of only digits.
 * n does not contain any leading zeros and represents a positive integer.
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public static void main(String[] args) {
        List<Test> tests = Arrays.asList(
                new Test("32", 3),
                new Test("82734", 8),
                new Test("27346209830709182346", 9)
        );

        for (PartitioningIntoMinimumNumberOfDeciBinaryNumbers.Test test : tests) {
            long startTime = System.nanoTime();

            int result = bruteForce(test.input);

            System.out.println(String.format("%d nano", System.nanoTime() - startTime));
            System.out.println(String.format("Passed test: %s", Integer.toString(result).equals(Integer.toString(test.output))));
            System.out.println(Integer.toString(result));
        }
    }

    /**
     * See pdf for explanation, but basically the number of subtraction operations is equal to the
     * largest int in the string.
     *
     * Runtime: O(n)
     * Space Complexity: O(n)
     *
     * Runtime
     * 14 ms
     * Beats
     * 21.38%
     * Memory
     * 43.1 MB
     * Beats
     * 55.54%
     */
    private static int bruteForce(String n) {
        char[] nArray = n.toCharArray();
        int max = 0;

        for (char ch : nArray) {
            int curCh = Character.getNumericValue(ch);

            if (curCh == 9) {
                return curCh;
            }

            if (curCh > max) {
                max = curCh;
            }
        }
        return (int) max;
    }

    private static class Test {
        String input;
        int output;

        Test(String input, int output) {
            this.input = input;
            this.output = output;
        }
    }
}
