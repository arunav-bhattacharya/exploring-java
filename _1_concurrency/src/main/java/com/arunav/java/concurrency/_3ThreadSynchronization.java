package com.arunav.java.concurrency;

public class _3ThreadSynchronization {

    public static void main(String[] args) {

    }
}

class Counter implements Runnable {
    private Integer counter = 0;

    void increment() {
        counter++;
    }

    void decrement() {
        counter--;
    }

    @Override
    public void run() {
        synchronized (counter) {
            increment();
            decrement();
        }
        System.out.println("Counter=" + counter);
    }
}
