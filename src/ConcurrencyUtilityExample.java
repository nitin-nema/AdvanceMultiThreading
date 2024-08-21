import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyUtilityExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {
            Thread.sleep(1000);
            return 10;
        });
        tasks.add(() -> {
            Thread.sleep(2000);
            return 20;
        });
        tasks.add(() -> {
            Thread.sleep(3000);
            return 30;
        });

        try {
            List<Future<Integer>> results = executor.invokeAll(tasks); // Submits all tasks and waits for completion

            for (Future<Integer> result : results) {
                try {
                    System.out.println("Result: " + result.get()); // Retrieve result of each task
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
