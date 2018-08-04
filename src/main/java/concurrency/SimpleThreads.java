package concurrency;

/**
 * @author FogHorn Systems, Inc.
 */
public class SimpleThreads {
    // Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String threadName, String message) {
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(threadName, importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage(threadName, "I wasn't done!");
            }
        }
    }

    public static void main(String args[])
        throws InterruptedException {

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        String threadName = "Main";
        Thread.currentThread().setName(threadName);

        threadMessage(threadName, "Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop(), "MessageLoop");
        t.start();

        threadMessage(threadName, "Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage(threadName, "Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(3000);
            if (((System.currentTimeMillis() - startTime) > patience)
                && t.isAlive()) {
                threadMessage(threadName, "Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage(threadName, "Finally!");
    }
}
