import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerTestCode;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestRunnerTest {
    @Test
    public void run_whenInputAndOutputString_thenSuccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        org.example.testrunner.Test test1 = new org.example.testrunner.Test("testInput1", "testOutput1");
        org.example.testrunner.Test test2 = new org.example.testrunner.Test("testInput2", "testOutput2");
        List<org.example.testrunner.Test> tests = Arrays.asList(test1, test2);

        List<String> testMethodNames = Arrays.asList("solution1", "solution2");
        int testMethodsSize = testMethodNames.size();
        Method[] testMethods = new Method[testMethodsSize];
        for (int i = 0; i < testMethodsSize; i++) {
            testMethods[i] = TestRunnerTestCode.StringInStringOutTest.class.getDeclaredMethod(testMethodNames.get(i), String.class);
        }
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new TestRunnerTestCode.StringInStringOutTest());
    }

    @Test
    public void run_whenDoubleArrayInDoubleArrayOut_thenSuccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        org.example.testrunner.Test test1 = new org.example.testrunner.Test(1.1, new double[]{10.10, 11.11});
        org.example.testrunner.Test test2 = new org.example.testrunner.Test(2.2, new double[]{20.20, 22.22});
        List<org.example.testrunner.Test> tests = Arrays.asList(test1, test2);

        List<String> testMethodNames = Arrays.asList("solution1", "solution2");
        int testMethodsSize = testMethodNames.size();
        Method[] testMethods = new Method[testMethodsSize];
        for (int i = 0; i < testMethodsSize; i++) {
            testMethods[i] = TestRunnerTestCode.DoubleInDoubleArrayOut.class.getDeclaredMethod(testMethodNames.get(i), double.class);
        }
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new TestRunnerTestCode.DoubleInDoubleArrayOut());
    }
}
