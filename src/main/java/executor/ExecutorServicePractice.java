package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author FogHorn Systems, Inc.
 */
public class ExecutorServicePractice {

    public static Runnable runnable1 = () -> {
        System.out.printf("Inside thread %s\n", Thread.currentThread().getName());
        System.out.println("Runnable1: Going to sleep for 2 sec to keep thread busy for nothing");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Runnable1 was interrupted");
        }
    };

    public static Runnable runnable2 = () -> {
        System.out.printf("Inside thread %s\n", Thread.currentThread().getName());
        System.out.println("Runnable2: I was dying to say Hi!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Runnable2 was interrupted");
        }
    };

    public static Runnable runnable3 = () -> {
        System.out.println("Now " + System.nanoTime());
        System.out.printf("Inside thread %s\n", Thread.currentThread().getName());
        System.out.println("Runnable3: I was just waiting for my chance!");
    };

    public static void executorService(ExecutorService executorService) {
        System.out.println("Submitting runnable 1");
        executorService.submit(runnable1);
        System.out.println("Submitting runnable 2");
        executorService.submit(runnable2);
        System.out.println("Submitting runnable 3");
        executorService.submit(runnable3);
        executorService.shutdown();
    }

    public static void scheduledService() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Submitting runnable 3 to be run after 2 secs. Now = " + System.nanoTime());
        service.schedule(runnable3, 2, TimeUnit.SECONDS);
        service.shutdown();
    }

    public static void scheduledServiceRepeating() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Submitting runnable 3 to be run repeatedly every 2 secs. Now = " + System.nanoTime());
//        service.scheduleAtFixedRate(runnable3, 0, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(runnable3, 0, 2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
//        executorService(Executors.newSingleThreadExecutor());
//        executorService(Executors.newFixedThreadPool(2));
//        scheduledService();
        scheduledServiceRepeating();

        System.out.println("BACK TO " + Thread.currentThread().getName());
    }

}
