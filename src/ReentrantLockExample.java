import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample implements Runnable {
    private final ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    public void increment() {
        lock.lock(); // Acquiring the lock
        try {
            counter++; // Critical section
        } finally {
            lock.unlock(); // Always release the lock in a finally block
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample example = new ReentrantLockExample();
        Thread t1 = new Thread(example);
        Thread t2 = new Thread(example);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Counter Value: " + example.counter); // Result is consistent.
    }
}
