package ru.otus.hw05;

import ru.otus.hw05.tests.PersonTests;

import java.lang.reflect.InvocationTargetException;

public class TestsRun {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        TestCore.run(new PersonTests());

    }
}
