package com.arunav.java.completablefuture;

public class Util {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getNumber() {
        System.out.println("Getting a number..." + Thread.currentThread());
        sleep(2000);
        return 7;
    }

    public static void printInteger(int number) {
        System.out.println(String.format("Accepting returned value=%s in thread=%s", number, Thread.currentThread()));
    }

    public static void printDouble(double number) {
        System.out.println(String.format("Accepting returned value=%s in thread=%s", number, Thread.currentThread()));
    }

    public static double transform(int number) {
        System.out.println(String.format("Transforming number=%s in thread=%s", number, Thread.currentThread()));
        return number * 2.5;
    }
}
