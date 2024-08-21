import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        System.out.println("Starting asynchronous task...");

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate a long-running task
                System.out.println("Asynchronous task completed!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Continue doing other work while the task is running
        System.out.println("Main thread continues execution...");

        // Wait for the task to complete
        future.join();
    }
}
