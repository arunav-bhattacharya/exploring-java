package com.arunav.java.concurrency;

public class _1ThreadExamples {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 executing");
            try {
                Thread.sleep(10000L);
                System.out.println("Thread2 completing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread2 executing");
            try {
                Thread.sleep(2000L);
                System.out.println("Thread2 completing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.setDaemon(true);
        t1.start();
        t2.start();
        t1.interrupt();
    }
}
