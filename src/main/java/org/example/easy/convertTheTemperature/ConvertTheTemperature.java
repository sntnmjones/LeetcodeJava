package org.example.easy.convertTheTemperature;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-the-temperature/
 * <p>
 * You are given a non-negative floating point number rounded to two decimal places celsius, that denotes the temperature in Celsius.
 * You should convert Celsius into Kelvin and Fahrenheit and return it as an array ans = [kelvin, fahrenheit].
 * Return the array ans. Answers within 10-5 of the actual answer will be accepted.
 * Note that:
 * Kelvin = Celsius + 273.15
 * Fahrenheit = Celsius * 1.80 + 32.00
 * <p>
 * Constraints:
 * 0 <= celsius <= 1000
 */
public class ConvertTheTemperature {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test(36.50, new double[]{309.65000, 97.70000})
        );

        List<String> testMethodNames = Arrays.asList("bruteForce");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, double.class, ConvertTheTemperature.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new ConvertTheTemperature());
    }

    /**
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 40.9 MB
     * Beats
     * 75.84%
     */
    protected double[] bruteForce(double celsius) {
        return new double[]{
                (celsius + 273.15),
                ((celsius * 1.8) + 32)
        };
    }
}
