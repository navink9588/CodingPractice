package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author FogHorn Systems, Inc.
 */
public class FutureAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<String> callable = new Callable<String>() {
            @Override public String call() throws Exception {
                System.out.println("Inside callable. Sleeping first.");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Callable awake. Returing");
                return "Hello World!";
            }
        };

        System.out.println("Submitting callable to the executor service");
        Future<String> future = service.submit(callable);
        service.shutdown();
        System.out.println("Submitted successfully");

        System.out.println("Lets get the result");
        System.out.println(future.get());
    }
}
