package com.arunav.java.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static com.arunav.java.completablefuture.Util.getNumber;
import static com.arunav.java.completablefuture.Util.sleep;

public class CF3Completing {

    public static void main(String[] args) {

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        System.out.println(completableFuture);

        /*
         * Building the pipeline of actions to perform on completableFuture, to be executed in future when the
         * completableFuture is complete
         */
        process(completableFuture);
        System.out.println(completableFuture);

        /*
         * When you have the result of a completableFuture and you want to execute a pipeline of actions on the result,
         * pass the result to the complete() method of the completableFuture
         */
        completableFuture.complete(getNumber());
        System.out.println(completableFuture);

        

        /*
         * If you want to run the completableFuture in a separate thread, then you can run the whole thing in a
         * separate async thread, as shown below in the commented code
         */
/*        CompletableFuture.runAsync(() -> {
            CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
            process(completableFuture);
            completableFuture.complete(getCompletableFuture());
        });*/

        System.out.println("Waiting for the main thread to complete...." + Thread.currentThread());
        sleep(7000);
    }

    private static void process(CompletableFuture<Integer> completableFuture) {
        ForkJoinPool pool = new ForkJoinPool(10);
        completableFuture.thenApplyAsync(Util::transform, pool)
                .thenAcceptAsync(Util::printDouble, pool);
    }
}
