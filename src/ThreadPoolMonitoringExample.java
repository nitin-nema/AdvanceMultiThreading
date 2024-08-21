import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolMonitoringExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Monitoring thread pool
        System.out.println("Core Pool Size: " + executor.getCorePoolSize());
        System.out.println("Maximum Pool Size: " + executor.getMaximumPoolSize());
        System.out.println("Current Pool Size: " + executor.getPoolSize());
        System.out.println("Active Threads: " + executor.getActiveCount());
        System.out.println("Pending Tasks: " + executor.getQueue().size());

        executor.shutdown();
    }
}
