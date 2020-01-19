package ru.otus.hw01;

import com.google.common.math.IntMath;

public class HelloOtus {

    public static void main(String... args) {
        int checked = IntMath.checkedPow(2, 30);
        System.out.println(checked);
    }

}
