import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            System.out.println("Calculating sum by " + Thread.currentThread().getName());
            Thread.sleep(2000);
            return 10 + 20;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Future result: " + future.get()); // Blocks until the result is available

        executor.shutdown();
    }
}
