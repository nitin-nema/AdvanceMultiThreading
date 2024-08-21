class SynchronizedBlockExample implements Runnable {
    private final Object lock = new Object();
    private int counter = 0;

    public void increment() {
        synchronized (lock) {
            //reduce the scope of lock and improve the performance
            counter++; // Only this block is synchronized.

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlockExample example = new SynchronizedBlockExample();
        Thread t1 = new Thread(example);
        Thread t2 = new Thread(example);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Counter Value: " + example.counter); // Result is consistent.
    }
}
