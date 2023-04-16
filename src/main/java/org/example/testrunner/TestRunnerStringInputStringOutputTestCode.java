package org.example.testrunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestRunnerStringInputStringOutputTestCode {
    private static Test test1 = new Test("testInput1", "testOutput1");
    private static Test test2 = new Test("testInput2", "testOutput2");

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Test> tests = Arrays.asList(test1, test2);

        List<String> testMethodNames = Arrays.asList("solution1", "solution2");
        int testMethodsSize = testMethodNames.size();
        Method[] testMethods = new Method[testMethodsSize];
        for (int i = 0; i < testMethodsSize; i++) {
            testMethods[i] = TestRunnerStringInputStringOutputTestCode.class.getDeclaredMethod(testMethodNames.get(i), String.class);
        }
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new TestRunnerStringInputStringOutputTestCode());
    }

    private String solution1(String testInput) {
        return testInput.equals(test1.input) ? (String) test1.output : (String) test2.output;
    }

    private String solution2(String testInput) {
        return testInput.equals(test1.input) ? (String) test1.output : (String) test2.output;
    }
}
