import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolWithMonitoring {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, // Core pool size
                5, // Maximum pool size
                30, // Keep-alive time
                TimeUnit.SECONDS, // Time unit for keep-alive
                new LinkedBlockingQueue<>(10), // Work queue
                new ThreadPoolExecutor.CallerRunsPolicy() // Rejected execution handler
        );

        for (int i = 1; i <= 15; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Monitor thread pool
        System.out.println("Core Pool Size: " + executor.getCorePoolSize());
        System.out.println("Maximum Pool Size: " + executor.getMaximumPoolSize());
        System.out.println("Current Pool Size: " + executor.getPoolSize());
        System.out.println("Active Threads: " + executor.getActiveCount());
        System.out.println("Pending Tasks: " + executor.getQueue().size());

        executor.shutdown(); // Initiates an orderly shutdown

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                executor.shutdownNow(); // Forcefully shutdown
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Interrupt current waiting
            Thread.currentThread().interrupt();
        }
    }
}
