class PriorityThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " with priority " +
                Thread.currentThread().getPriority() + " is running."); //
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        PriorityThread highPriority = new PriorityThread();
        PriorityThread lowPriority = new PriorityThread();
        PriorityThread normPriority = new PriorityThread();

        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        normPriority.setPriority(Thread.NORM_PRIORITY);

        highPriority.start();
        lowPriority.start();
        normPriority.start();
    }
}
