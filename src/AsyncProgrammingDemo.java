import java.util.concurrent.CompletableFuture;

public class AsyncProgrammingDemo {
    public static void main(String[] args) {
        // Start two asynchronous tasks
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        // Combine the results of both futures
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2,
                (greeting, target) -> greeting + ", " + target + "!");

        // Print the combined result
        combinedFuture.thenAccept(result -> System.out.println("Combined Result: " + result));
    }
}
