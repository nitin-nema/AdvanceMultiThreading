import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class AdvancedSyncExample {
    private int counter = 0;
    private final Object lock = new Object();
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    // Synchronized Method
    public synchronized void incrementSynchronizedMethod() {
        counter++;
    }

    // Synchronized Block
    public void incrementSynchronizedBlock() {
        synchronized (lock) {
            counter++;
        }
    }

    // ReentrantLock
    public void incrementReentrantLock() {
        reentrantLock.lock();
        try {
            counter++;
        } finally {
            reentrantLock.unlock();
        }
    }

    //Reentrant Read Write Lock
    public int getCounter() {
        rwLock.readLock().lock(); // Acquire the read lock
        try {
            return counter; // Critical section for reading
        } finally {
            rwLock.readLock().unlock(); // Always release the read lock
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AdvancedSyncExample example = new AdvancedSyncExample();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.incrementSynchronizedMethod();
                example.incrementSynchronizedBlock();
                example.incrementReentrantLock();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + example.getCounter());
    }
}
