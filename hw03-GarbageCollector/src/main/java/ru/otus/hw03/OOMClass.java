package ru.otus.hw03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OOMClass implements BenchmarkMBean{
    private int size;

    public OOMClass(int size) {
        this.size = size;
    }

    public void run() {

        List<Long> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < size; i++) {
                list.add(0L);
            }
            list.subList(
                    list.size() - (int)(size * 0.9995),
                    list.size())
                                .clear();
        }
    }

}
