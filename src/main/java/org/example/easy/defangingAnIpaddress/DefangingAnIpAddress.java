package org.example.easy.defangingAnIpaddress;

import org.example.testrunner.Test;
import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 * <p>
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * Constraints:
 * The given address is a valid IPv4 address.
 */
public class DefangingAnIpAddress {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Test> tests = Arrays.asList(
                new Test("1.1.1.1", "1[.]1[.]1[.]1"),
                new Test("255.100.50.0", "255[.]100[.]50[.]0")
        );

        List<String> testMethodNames = Arrays.asList("bruteForce", "manual");
        Method[] testMethods = TestRunnerUtil.getTestMethods(testMethodNames, String.class, DefangingAnIpAddress.class);
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new DefangingAnIpAddress());
    }

    /**
     * replaceAll will iterate through the string and replace every occurrence of '.' with '[.]'
     * <p>
     * Runtime: O(n)
     * Space Complexity: O(n)
     * <p>
     * Runtime
     * 2 ms
     * Beats
     * 26.76%
     * Memory
     * 40.9 MB
     * Beats
     * 16.42%
     */
    protected String bruteForce(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    /**
     * Using StringBuilder to manually iterate through string and replace each occurrence
     * <p>
     * Runtime: O(n)
     * Space Complexity: O(n)
     * <p>
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 40.1 MB
     * Beats
     * 92.30%
     */
    protected String manual(String address) {
        int addressLength = address.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < addressLength; i++) {
            if (address.charAt(i) != '.') {
                result.append(address.charAt(i));
            } else {
                result.append("[.]");
            }
        }

        return result.toString();
    }
}
