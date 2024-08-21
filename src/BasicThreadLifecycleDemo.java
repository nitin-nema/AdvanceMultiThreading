class LifecycleThread extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is Running");
            try {
                wait(500);  // Thread goes into WAITING state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is Resumed and Completed");
        }
    }
}

public class BasicThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        LifecycleThread thread = new LifecycleThread();
        System.out.println("Thread state before start: " + thread.getState());  // NEW

        thread.start();
        System.out.println("Thread state after start: " + thread.getState());  // RUNNABLE

        Thread.sleep(100);  // Ensuring thread gets into the RUNNABLE state
        System.out.println("Thread state during execution: " + thread.getState());  // WAITING or RUNNABLE

        synchronized (thread) {
            thread.notify();  // Wakes up the thread from WAITING state
        }

        thread.join();
        System.out.println("Thread state after completion: " + thread.getState());  // TERMINATED
    }
}
