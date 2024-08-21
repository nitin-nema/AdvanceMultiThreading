import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(); // Cached thread pool

        for (int i = 1; i <= 20; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Initiates an orderly shutdown
    }
}
