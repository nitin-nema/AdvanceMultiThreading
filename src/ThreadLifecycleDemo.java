
class MyLifecycleThread extends Thread {
    public void run() {
        System.out.println("Thread is running.");
        try {
            Thread.sleep(2000);  // Simulate some work
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread completed.");
    }
}

public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        MyLifecycleThread thread = new MyLifecycleThread();
        System.out.println("Thread state: " + thread.getState());  // NEW
        thread.start();
        System.out.println("Thread state after start: " + thread.getState());  // RUNNABLE
        try {
            Thread.sleep(100);  // Allow thread to start running
            System.out.println("Thread state while running: " + thread.getState());  // RUNNABLE or TIMED_WAITING (due to sleep)
            thread.join();
            System.out.println("Thread state after completion: " + thread.getState());  // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

