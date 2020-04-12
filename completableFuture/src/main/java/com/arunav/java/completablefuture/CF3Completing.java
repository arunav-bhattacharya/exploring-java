package com.arunav.java.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static com.arunav.java.completablefuture.Util.sleep;

public class CF3Completing {

    public static void main(String[] args) {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Util::getNumber);

        ForkJoinPool pool = new ForkJoinPool(10);
        CompletableFuture<Double> doubleCompletableFuture = completableFuture.thenApplyAsync(Util::transform);

        CompletableFuture<Void> voidCompletableFuture = doubleCompletableFuture.thenAcceptAsync(Util::printDouble);

        voidCompletableFuture.thenRun(() -> System.out.println("Running..."));

        sleep(5000);
    }
}
