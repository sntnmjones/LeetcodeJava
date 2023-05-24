package org.example.easy.jewelsAndStones;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/jewels-and-stones
 * <p>
 * You're given strings jewels representing the types of stones that are jewels, and stones
 * representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Constraints:
 * 1 <= jewels.length, stones.length <= 50
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 */
public class JewelsAndStones {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test("aA", "aAAbbbb", 3)
        );

        List<String> testMethodNames = Arrays.asList("bruteForce", "nSquared", "mapUsingChars");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, String.class, String.class, JewelsAndStones.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new JewelsAndStones());
    }

    /**
     * Runtime: O(n)
     * Space Complexity: O(n)
     * <p>
     * Runtime
     * 7 ms
     * Beats
     * 5.63%
     * Memory
     * 42.9 MB
     * Beats
     * 5.5%
     */
    protected int bruteForce(String jewels, String stones) {
        // Create map of stones with count
        Map<String, Integer> numStones = new HashMap<>();
        for (String stone : stones.split("")) {
            if (numStones.containsKey(stone)) {
                int newCount = numStones.get(stone) + 1;
                numStones.put(stone, newCount);
            } else {
                numStones.put(stone, 1);
            }
        }

        // Get sum of jewels
        int total = 0;
        for (String jewel : jewels.split("")) {
            if (numStones.containsKey(jewel)) {
                total += numStones.get(jewel);
            }
        }

        return total;
    }

    /**
     * Runtime: O(n^2)
     * Space Complexity: O(1)
     * <p>
     * Runtime
     * 1 ms
     * Beats
     * 91.39%
     * Memory
     * 41 MB
     * Beats
     * 35.89%
     */
    protected int nSquared(String jewels, String stones) {
        int total = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == (stones.charAt(j))) {
                    total += 1;
                }
            }
        }
        return total;
    }

    /**
     * Runtime: O(n)
     * Space Complexity: O(n)
     *
     * Runtime
     * 1 ms
     * Beats
     * 91.39%
     * Memory
     * 40.8 MB
     * Beats
     * 74.41%
     */
    protected int mapUsingChars(String jewels, String stones) {
        // Create map of stones with count
        Map<Character, Integer> numStones = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            Character stone = stones.charAt(i);
            if (numStones.containsKey(stone)) {
                int newCount = numStones.get(stone) + 1;
                numStones.put(stone, newCount);
            } else {
                numStones.put(stone, 1);
            }
        }

        // Get sum of jewels
        int total = 0;
        for (int i = 0; i < jewels.length(); i++) {
            Character jewel = jewels.charAt(i);
            if (numStones.containsKey(jewel)) {
                total += numStones.get(jewel);
            }
        }

        return total;
    }
}
