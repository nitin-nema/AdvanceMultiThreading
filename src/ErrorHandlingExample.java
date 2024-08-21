import java.util.concurrent.CompletableFuture;

public class ErrorHandlingExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate an exception
            if (true) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Success";
        });

        future.exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return "Default Result";
        }).thenAccept(result -> System.out.println("Result: " + result));
    }
}
