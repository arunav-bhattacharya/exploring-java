package com.arunav.java.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static com.arunav.java.completablefuture.Util.sleep;

public class CF2Processing {

    public static void main(String[] args) {

        thenAccept();

        thenApply();

        thenRun();

        chaining();
        // Waiting for the main thread to complete
        System.out.println("Waiting for the main thread to complete...");
        sleep(5000);
    }

    private static void chaining() {
        ForkJoinPool pool1 = new ForkJoinPool(2);
        CompletableFuture.supplyAsync(Util::getNumber, pool1)
                .thenApplyAsync(Util::transform, pool1)
                .thenAcceptAsync(Util::printDouble, pool1)
                .thenRunAsync(() -> System.out.println("Running from the chained call" + Thread.currentThread()), pool1);
    }

    private static void thenAccept() {
        System.out.println("\nIn thenAccept()" + Thread.currentThread());
        ForkJoinPool pool1 = new ForkJoinPool(2);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Util::getNumber, pool1);

        // Uncomment the sleep to have the thenAccept run on main thread
        //sleep(1100);

        /*
         * 1. thenAccept() - non-async method
         * When thenAccept() method is called it can be called by either the calling thread or the completing thread.
         */
        // If the main thread is free, it can execute the thenAccept() method.
        // If the main thread is not free or it has done processing beyond this instruction,
        // then the supplyAsync completableFuture thread will take care of calling thenAccept()
        completableFuture.thenAccept(Util::printInteger);

        System.out.println("In main" + Thread.currentThread());

        /*
         * 2. thenAcceptAsync() - async method
         * By default they'll run in common pool, unless a separate pool is provided
         */
        // This executes in a thread from common pool
        completableFuture.thenAcceptAsync(Util::printInteger);

        // This executes in a thread from separate pool
        ForkJoinPool pool2 = new ForkJoinPool(2);
        completableFuture.thenAcceptAsync(Util::printInteger, pool2);
    }

    private static void thenApply() {
        System.out.println("\nIn thenApply()" + Thread.currentThread());
        ForkJoinPool pool1 = new ForkJoinPool(2);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Util::getNumber, pool1);
        CompletableFuture<Double> doubleCompletableFuture = completableFuture.thenApplyAsync(Util::transform);
        doubleCompletableFuture.thenAcceptAsync(Util::printDouble);
    }

    private static void thenRun() {
        System.out.println("\nIn thenRun()"+ Thread.currentThread());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Util::getNumber);
        ForkJoinPool pool = new ForkJoinPool(10);
        CompletableFuture<Double> doubleCompletableFuture = completableFuture.thenApplyAsync(Util::transform, pool);
        CompletableFuture<Void> voidCompletableFuture = doubleCompletableFuture.thenAcceptAsync(Util::printDouble);
        voidCompletableFuture.thenRun(() -> System.out.println("Running..." + Thread.currentThread()));
    }

}
