package org.example.testrunner;


import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestRunner {
//    private static Map<Class, Class> classMap = Map.of(String.class, (String));

    List<Test> tests;
    Method[] testMethods;

    public TestRunner(List<Test> tests, Method[] testMethods) {
        this.tests = tests;
        this.testMethods = testMethods;
    }

    private static void printResults(String result, boolean didPass) {
        System.out.println(String.format("Passed test: %s", didPass));
        System.out.println("Test Result: " + result);
        System.out.println("--------------------------------------------------------");
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

                compareObjects(result, test.output);
            }
        }
    }

    private void compareObjects(Object result, Object testOutput) throws IllegalAccessException {
        Class<?> clazz1 = result.getClass();
        Class<?> clazz2 = testOutput.getClass();

        if (!clazz1.equals(clazz2)) {
            printResults((String) result, false);
        }

        switch (clazz1.getTypeName()) {
            case "java.lang.String":
                boolean isSame = Objects.equals(result, testOutput);
                printResults((String) result, isSame);
                break;
            case "double[]":
                compareArray(result, testOutput, double[].class);
                break;
            default:
                System.out.println("Class not handled for comparison");
        }
    }

    private boolean compareArray(Object result, Object testOutput, Class clazz) {
        boolean isSame = true;
        int resultSize = Array.getLength(result);
        int testOutputSize = Array.getLength(testOutput);

        if (resultSize - testOutputSize == 0) {
            for (int i = 0; i < resultSize; i++) {
                if (!Array.get(result, i).equals(Array.get(testOutput, i))) {
                    isSame = false;
                    break;
                }
            }
        }
        switch (clazz.getTypeName()) {
            case "double[]":
                double[] casted = (double[]) result;
                printResults(Arrays.toString(casted), isSame);
                break;
        }

        return isSame;
    }
}
