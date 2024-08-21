class RaceConditionExample implements Runnable {
    private int counter = 0;

    public void increment() {
        counter++; // This is not atomic and can lead to a race condition.
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RaceConditionExample example = new RaceConditionExample();
        Thread t1 = new Thread(example);
        Thread t2 = new Thread(example);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Counter Value: " + example.counter); // Result may be inconsistent.
    }
}
