package org.example.easy.finalValueOfVariableAfterPerformingOperations;

import org.example.easy.BuildArrayFromPermutation;
import org.example.easy.defangingAnIpaddress.DefangingAnIpAddress;
import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 * <p>
 * There is a programming language with only four operations and one variable X:
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 * Given an array of strings operations containing a list of operations,
 * return the final value of X after performing all the operations.
 * <p>
 * Constraints:
 * 1 <= operations.length <= 100
 * operations[i] will be either "++X", "X++", "--X", or "X--".
 */
public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test(new String[]{"--X","X++","X++"}, 1)
        );

        List<String> testMethodNames = Arrays.asList("bruteForce");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, String[].class, FinalValueOfVariableAfterPerformingOperations.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new FinalValueOfVariableAfterPerformingOperations());
    }

    protected int bruteForce(String[] operations) {
        return 1;
    }
}
