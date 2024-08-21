class SynchronizedMethodExample implements Runnable {
    private int counter = 0;

    public synchronized void increment() {
        counter++; // Now this is thread-safe.
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedMethodExample example = new SynchronizedMethodExample();
        Thread t1 = new Thread(example);
        Thread t2 = new Thread(example);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Counter Value: " + example.counter); // Result is consistent.
    }
}
