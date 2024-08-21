import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class FairLockExample {

    private static final int NUM_THREADS = 5;
    private static final int NUM_TASKS = 10;

    private final ReentrantLock lock = new ReentrantLock(true); // Fairness enabled
    private final Condition condition = lock.newCondition();
    private int sharedResource = 0;

    public static void main(String[] args) {
        FairLockExample example = new FairLockExample();
        example.runExample();
    }

    public void runExample() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_TASKS; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    performTask(taskId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                    System.out.println("Thread " + taskId + " was interrupted.");
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private void performTask(int taskId) throws InterruptedException {
        boolean lockAcquired = false;
        try {
            lockAcquired = lock.tryLock(2, TimeUnit.SECONDS); // Attempt to acquire the lock with a timeout
            if (lockAcquired) {
                System.out.println("Thread " + taskId + " acquired the lock.");
                // Simulate some work with the shared resource
                sharedResource++;
                System.out.println("Shared resource value: " + sharedResource);
                // Simulate task processing
                Thread.sleep(500);
            } else {
                System.out.println("Thread " + taskId + " could not acquire the lock within the timeout.");
            }
        } finally {
            if (lockAcquired) {
                lock.unlock(); // Ensure the lock is unlocked
                System.out.println("Thread " + taskId + " released the lock.");
            }
        }
    }
}
