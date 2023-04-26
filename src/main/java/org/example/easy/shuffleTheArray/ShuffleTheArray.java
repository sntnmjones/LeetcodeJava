package org.example.easy.shuffleTheArray;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ShuffleTheArray {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test(new int[]{2,5,1,3,4,7}, 3, new int[]{2,3,5,4,1,7})
        );

        List<String> testMethodNames = Arrays.asList("bruteForce");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, int[].class, int.class, ShuffleTheArray.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new ShuffleTheArray());
    }

    protected int[] bruteForce(int[] nums, int n) {
        return new int[]{2,3,5,4,1,7};
    }
}
