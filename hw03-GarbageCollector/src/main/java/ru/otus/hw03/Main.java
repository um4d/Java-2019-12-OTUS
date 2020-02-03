package ru.otus.hw03;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OOMClass benchmark = new OOMClass(1000 * 1000 * 1);
        long beginTime = System.currentTimeMillis();
        try {
            benchmark.run();
        } catch (OutOfMemoryError e){
            e.printStackTrace();
            System.out.println( "time: " + (System.currentTimeMillis() - beginTime) / 1000);
        }
    }
}
