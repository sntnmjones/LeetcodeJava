package org.example.testrunner;


import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
                printer(test.input, PrintType.Input);
                printer(test.output, PrintType.Output);

                long startTime = System.nanoTime();
                Object result = null;
                if (test.target == null) {
                    result = test.output.getClass().cast(testMethod.invoke(testClass, test.input));
                } else {
                    result = test.output.getClass().cast(testMethod.invoke(testClass, test.input, test.target));
                }
                System.out.println(String.format("Test Time: %d nano", System.nanoTime() - startTime));

                compareObjects(result, test.output);
            }
        }
    }

    private void printer(Object object, PrintType printType) {
        String objectStr = "";
        if (object instanceof double[]) {
            double[] casted = (double[]) object;
            objectStr = Arrays.toString(casted);
        } else if (object instanceof int[]) {
            int[] casted = (int[]) object;
            objectStr = Arrays.toString(casted);
        } else if (object instanceof String) {
            objectStr = object.toString();
        } else if (object instanceof Integer) {
            objectStr = String.valueOf((int) object);
        } else {
            System.out.println("printer: Object not supported");
        }
        System.out.println(String.format("Test %s: %s", printType.name(), objectStr));
    }

    private void printResults(String result, boolean didPass) {
        System.out.println(String.format("Passed test: %s", didPass));
        printer(result, PrintType.Result);
        System.out.println("--------------------------------------------------------");
    }

    private void compareObjects(Object result, Object testOutput) throws IllegalAccessException {
        if (result == null) {
            throw new RuntimeException("result is null");
        }

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

    private enum PrintType {
        Input,
        Output,
        Result
    }
}
