package com.arunav.java.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static com.arunav.java.completablefuture.Util.sleep;

public class CF1Creating {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
         * 1. Run Async - Runs in a separate thread and takes in a runnable, that means it returns nothing
         */
        // 1.a Using common pool
        CompletableFuture.runAsync(() -> {
            System.out.println("running async in common pool  = " + Thread.currentThread());
            sleep(5000);
        });
        ForkJoinPool pool = new ForkJoinPool(10);

        // 1.b Using fork join pool
        CompletableFuture.runAsync(() -> {
            System.out.println("running async in forkjoin pool= " + Thread.currentThread());
        }, pool);
        System.out.println("In main = " + Thread.currentThread());

        /*
         * 2. Supply Async - Runs in a separate thread and takes in a Supplier, that means it returns something
         */
        CompletableFuture<Integer> compFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running inside supply async..." + Thread.currentThread());
            sleep(1000);
            return 3;
        }, pool);

        // Getting the result
        // 2.a getNow() - Gets a default value if the original value is not ready yet. Does not block the main thread.
        System.out.println(compFuture.getNow(-999));
        // 2.b get() - Blocking the main thread until the result is ready
        System.out.println(compFuture.get());
        System.out.println("In main 2 = " + Thread.currentThread());
    }
}
