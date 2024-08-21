public class SynchronousExample {
    public static void main(String[] args) {
        System.out.println("Starting synchronous task...");

        // Simulate a long-running task
        try {
            Thread.sleep(2000);
            System.out.println("Synchronous task completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread continues execution...");
    }
}
