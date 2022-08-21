package com.arunav.java.concurrency;

import java.util.concurrent.CompletableFuture;

public class ThreadExamples {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        t1.start();
        Thread t2 = new Thread();
        t2.start();
        Example example = new Example();

        CompletableFuture.runAsync(() -> example.method1(t1));
        CompletableFuture.runAsync(() -> example.method1(t2));

        t1.join();
        t2.join();

//        example.method1(t1);
//        example.method2(t2);
    }
}

class Example {
    public void method1(Runnable r1) {
        r1.run();
        System.out.println("Method1" + Thread.currentThread());
    }

    public void method2(Runnable r1) {
        r1.run();
        System.out.println("Method2" + Thread.currentThread());
    }

}
