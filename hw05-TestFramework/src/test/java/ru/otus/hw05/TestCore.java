package ru.otus.hw05;

import ru.otus.hw05.annotations.After;
import ru.otus.hw05.annotations.Before;
import ru.otus.hw05.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class TestCore {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private static int pass = 0;
    private static int fail = 0;


    public static void run(Object testClass) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {

        runBefore(testClass);
        runTests(testClass);
        runAfter(testClass);

    }


    private static void runBefore(Object testClass) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Class<?> testClazz = testClass.getClass();
        final List<Method> beforeMethods = getMethodsByAnnotation(testClazz, Before.class);

        for (Method m : beforeMethods) {
            String methodName = m.getName();
            testClazz.getMethod(methodName).invoke(testClass);
        }
    }


    private static void runAfter(Object testClass) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Class<?> testClazz = testClass.getClass();
        final List<Method> beforeMethods = getMethodsByAnnotation(testClazz, After.class);

        for (Method m : beforeMethods) {
            String methodName = m.getName();
            testClazz.getMethod(methodName).invoke(testClass);
        }

        System.out.println(String.format("Tests " + ANSI_GREEN + "PASSED: %s" + ANSI_RESET, pass));
        System.out.println(String.format("Tests " + ANSI_RED + "FAILED: %s" + ANSI_RESET, fail));

    }


    private static void runTests(Object testClass) {

        Class<?> testClazz = testClass.getClass();
        final List<Method> testMethods = getMethodsByAnnotation(testClazz, Test.class);

        for (Method m : testMethods) {
            String methodName = m.getName();
            String description = m.getDeclaredAnnotation(Test.class).value();
            try {
                testClazz.getMethod(methodName).invoke(testClass);
                System.out.println(String.format("Test name: %s\n" + "Description: %s\n" + ANSI_GREEN + "PASS\n" + ANSI_RESET,
                        methodName, description));
                pass++;
            } catch (Throwable e) {
                System.out.println(String.format("Test name: %s\n" + "Description: %s\n" + ANSI_RED + "FAIL" + ANSI_RESET,
                        methodName,description));
                System.out.println(e.getCause() + "\n");
                fail++;
            }
        }
    }


    private static List<Method> getMethodsByAnnotation(Class<?> testClazz, Class<? extends Annotation> annotation) {

        Method[] allMethods = testClazz.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();

        for (Method m : allMethods) {
            Annotation[] beforeMethodAnnotations = m.getDeclaredAnnotations();
            for (Annotation a : beforeMethodAnnotations) {
                if (a.annotationType().equals(annotation)) {
                    testMethods.add(m);
                }
            }
        }
        return testMethods;
    }
}
