import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomExecutorExample {
    public static void main(String[] args) {
        ExecutorService customExecutor = Executors.newFixedThreadPool(4);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Processed with custom executor";
        }, customExecutor);

        future.thenAccept(result -> System.out.println("Result: " + result));

        customExecutor.shutdown();
    }
}
