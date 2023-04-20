package org.example.testrunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestRunnerTestCode {
    public static class StringInStringOutTest {
        private static Test test1 = new Test("testInput1", "testOutput1");
        private static Test test2 = new Test("testInput2", "testOutput2");

        public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

            List<Test> tests = Arrays.asList(test1, test2);

            List<String> testMethodNames = Arrays.asList("solution1", "solution2");
            int testMethodsSize = testMethodNames.size();
            Method[] testMethods = new Method[testMethodsSize];
            for (int i = 0; i < testMethodsSize; i++) {
                testMethods[i] = TestRunnerTestCode.StringInStringOutTest.class.getDeclaredMethod(testMethodNames.get(i), String.class);
            }
            TestRunner testRunner = new TestRunner(tests, testMethods);
            testRunner.run(new TestRunnerTestCode.StringInStringOutTest());
        }

        private String solution1(String testInput) {
            return testInput.equals(test1.input) ? (String) test1.output : (String) test2.output;
        }

        private String solution2(String testInput) {
            return testInput.equals(test1.input) ? (String) test1.output : (String) test2.output;
        }
    }

    public static class DoubleInDoubleArrayOut {
        private static Test test1 = new Test(1.1, new double[]{10.10, 11.11});
        private static Test test2 = new Test(2.2, new double[]{20.20, 22.22});

        public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

            List<Test> tests = Arrays.asList(test1, test2);

            List<String> testMethodNames = Arrays.asList("solution1", "solution2");
            int testMethodsSize = testMethodNames.size();
            Method[] testMethods = new Method[testMethodsSize];
            for (int i = 0; i < testMethodsSize; i++) {
                testMethods[i] = TestRunnerTestCode.DoubleInDoubleArrayOut.class.getDeclaredMethod(testMethodNames.get(i), String.class);
            }
            TestRunner testRunner = new TestRunner(tests, testMethods);
            testRunner.run(new TestRunnerTestCode.DoubleInDoubleArrayOut());
        }

        private double[] solution1(double testInput) {
            return testInput == (double) test1.input ? (double[]) test1.output : (double[]) test2.output;
        }

        private double[] solution2(double testInput) {
            return testInput == (double) test1.input ? (double[]) test1.output : (double[]) test2.output;
        }
    }
}
