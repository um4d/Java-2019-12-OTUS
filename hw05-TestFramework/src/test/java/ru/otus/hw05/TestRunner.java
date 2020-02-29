package ru.otus.hw05;

import ru.otus.hw05.annotations.Test;
import ru.otus.hw05.tests.PersonTests;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;


public class TestRunner {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        PersonTests tests = new PersonTests();
        run(tests);

    }


    public static void run(Object testClass) {

        Class<?> testClazz = testClass.getClass();
        final Map<String, String> testMethods = getTestMethods(testClazz);

        for (Map.Entry<String, String> entry : testMethods.entrySet()) {
            String methodName = entry.getKey();
            String methodDescription = entry.getValue();
            try {
                testClazz.getMethod(methodName).invoke(testClass);
                System.out.println(String.format("Test name: %s\n" +
                                                 "Description: %s\n" +
                                                 ANSI_GREEN + "PASS\n" + ANSI_RESET,
                        methodName, methodDescription));
            } catch (Throwable e) {
                System.out.println(String.format("Test name: %s\n" +
                                                 "Description: %s\n" +
                                                 ANSI_RED + "FAIL" + ANSI_RESET,
                        methodName, methodDescription));
                System.out.println(e.getCause() + "\n");
            }
        }

    }

    private static Map<String, String> getTestMethods(Class<?> testClass) {

        Method[] allMethods = testClass.getDeclaredMethods();
        Map<String, String> testMethods = new LinkedHashMap<>();

        for (Method m : allMethods) {
            Annotation[] beforeMethodAnnotations = m.getDeclaredAnnotations();
            for (Annotation a : beforeMethodAnnotations) {
                String anName = a.annotationType().getSimpleName();
                if (anName.equals("Test")) {
                    Test testAnnotation = m.getDeclaredAnnotation(Test.class);
                    testMethods.put(
                            m.getName(),
                            testAnnotation.value()
                    );
                }
            }
        }

        return testMethods;
    }
}
