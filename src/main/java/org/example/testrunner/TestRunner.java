package org.example.testrunner;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TestRunner {
    List<Test> tests;
    Method[] testMethods;

    public TestRunner(List<Test> tests, Method[] testMethods) {
        this.tests = tests;
        this.testMethods = testMethods;
    }

    public void run(Object testClass) throws InvocationTargetException, IllegalAccessException {
        int testMethodLength = testMethods.length;

        for (Test test : tests) {
            for (int i = 0; i < testMethodLength; i++) {
                Method testMethod = testMethods[i];
                testMethod.setAccessible(true);
                System.out.println("Test Method: " + testMethod.getName());
                System.out.println("Test Input: " + test.input);
                System.out.println("Test Output: " + test.output);

                long startTime = System.nanoTime();
                Object result = test.output.getClass().cast(testMethod.invoke(testClass, test.input));
                System.out.println(String.format("Test Time: %d nano", System.nanoTime() - startTime));

                System.out.println(String.format("Passed test: %s", result.equals(test.output)));
                System.out.println("Test Result: " + result);
                System.out.println("--------------------------------------------------------");
            }
        }
    }
}
