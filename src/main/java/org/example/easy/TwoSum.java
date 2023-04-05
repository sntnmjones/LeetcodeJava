package org.example.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
            int[] result = twoSumBruteForce(test.input, test.target);
            System.out.println(Arrays.toString(result).equals(Arrays.toString(test.answer)));
            System.out.println(Arrays.toString(result));
        }
    }


    private static int[] twoSumBruteForce(int[] input, int target) {
        int inputLength = input.length;
        Set<Integer> answers = new HashSet<>();
        for (int i = 0; i < inputLength; i++) {
            for (int j = i + 1; j < inputLength; j++) {
                if (input[i] + input[j] == target) {
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
