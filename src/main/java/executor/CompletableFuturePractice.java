package executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author FogHorn Systems, Inc.
 */
public class CompletableFuturePractice {

    public static void completeTableFuture() throws ExecutionException, InterruptedException {
        // Run a task specified by a Runnable Object asynchronously.
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                // Simulate a long-running Job
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("I'll run in a separate thread than the main thread.");
            }
        });

        // Block and wait for the future to complete
        future.get();
    }

    public static void supplyAsync() throws ExecutionException, InterruptedException {
        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Result of the asynchronous computation";
            }
        });

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Lambda supplier";
        });

        // Block and get the result of the Future
        String result = completableFuture.get();
        System.out.println(result);
    }

    public static void thenApply() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> welcomeFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Navin";
        }, executorService)
            .thenApply(name -> {
                return String.format("Welcome %s!", name);
            })
            .thenApply(welcome -> {
               return String.format("%s Would you like a chocolate?", welcome);
            });

        executorService.shutdown();
        executorService.awaitTermination(4, TimeUnit.SECONDS);

        System.out.println("Printing welcome message");
        System.out.println(welcomeFuture.get());
        System.out.println("Done!");
    }

    public static void thenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Navin";
        }).thenAccept(name -> {
            System.out.printf("Hey %s. How are you?", name);
        });
        future.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        completeTableFuture();
//        supplyAsync();
//        thenApply();
        thenAccept();

    }

}
