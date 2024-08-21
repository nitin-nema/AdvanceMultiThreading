import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionHandling {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Data";
        }).thenApply(data -> {
            System.out.println("Processing " + data);
            return data.length();
        }).exceptionally(ex -> {
            System.err.println("Exception: " + ex.getMessage());
            return -1; // Returning default value in case of an exception
        }).thenAccept(length -> {
            System.out.println("Data length: " + length);
        });

        // Wait for all tasks to complete
        future.join();
    }
}
