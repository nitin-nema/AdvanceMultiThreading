import java.util.concurrent.CompletableFuture;

public class NonBlockingExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            sleep(1000);
            return "Task Result";
        });

        // Non-blocking call
        future.thenAccept(result -> System.out.println("Result: " + result));

        System.out.println("Main thread continues execution...");
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
