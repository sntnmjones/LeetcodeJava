package org.example.testrunner;

import java.lang.reflect.Method;
import java.util.List;

public class TestRunnerUtil {
    private TestRunnerUtil() {

    }

    public static Method[] getTestMethods(List<String> testMethodNames, Class methodArgType, Class clazz) throws NoSuchMethodException {
        return getTestMethods(testMethodNames, methodArgType, null, clazz);
    }

    public static Method[] getTestMethods(List<String> testMethodNames, Class methodArgTypeA, Class methodArgTypeB, Class clazz) throws NoSuchMethodException {
        int testMethodsSize = testMethodNames.size();
        Method[] testMethods = new Method[testMethodsSize];
        for (int i = 0; i < testMethodsSize; i++) {
            if (methodArgTypeB == null) {
                testMethods[i] = clazz.getDeclaredMethod(testMethodNames.get(i), methodArgTypeA);
            } else {
                testMethods[i] = clazz.getDeclaredMethod(testMethodNames.get(i), methodArgTypeA, methodArgTypeB);
            }
        }
        return testMethods;
    }
}
