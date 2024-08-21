import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExample {
    public static void main(String[] args) {
        // Creating a custom thread pool
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // Core pool size
                4, // Maximum pool size
                60, // Keep-alive time
                TimeUnit.SECONDS, // Time unit for keep-alive
                new LinkedBlockingQueue<>(), // Work queue
                new ThreadPoolExecutor.CallerRunsPolicy() // Rejected execution handler
        );

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown(); // Initiates an orderly shutdown
    }
}
