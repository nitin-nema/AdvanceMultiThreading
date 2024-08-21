import java.util.concurrent.CompletableFuture;

public class AsynchronousExample {
    public static void main(String[] args) {
        System.out.println("Starting asynchronous task...");

        // Run a task asynchronously
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(200); // Simulate a long-running task
                System.out.println("Asynchronous task completed!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Main thread continues execution...");
    }
}
