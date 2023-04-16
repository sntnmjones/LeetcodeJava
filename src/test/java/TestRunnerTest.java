import org.example.testrunner.TestRunner;
import org.example.testrunner.TestRunnerStringInputStringOutputTestCode;
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
            testMethods[i] = TestRunnerStringInputStringOutputTestCode.class.getDeclaredMethod(testMethodNames.get(i), String.class);
        }
        TestRunner testRunner = new TestRunner(tests, testMethods);
        testRunner.run(new TestRunnerStringInputStringOutputTestCode());
    }
}
