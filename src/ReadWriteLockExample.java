import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockExample {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int counter = 0;

    public void increment() {
        rwLock.writeLock().lock(); // Acquire the write lock
        try {
            counter++; // Critical section for writing
        } finally {
            rwLock.writeLock().unlock(); // Always release the write lock
        }
    }

    public int getCounter() {
        rwLock.readLock().lock(); // Acquire the read lock
        try {
            return counter; // Critical section for reading
        } finally {
            rwLock.readLock().unlock(); // Always release the read lock
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample example = new ReadWriteLockExample();

        Runnable writer = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Counter Value: " + example.getCounter());
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
