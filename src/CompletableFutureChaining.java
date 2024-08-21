import java.util.concurrent.CompletableFuture;

public class CompletableFutureChaining {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Fetching data...");
            return "Data";
        }).thenApply(data -> {
            System.out.println("Step 2: Processing " + data);
            return data.length();
        }).thenAccept(length -> {
            System.out.println("Step 3: Data length is " + length);
        });

        // Wait for all tasks to complete
        future.join();
    }
}
