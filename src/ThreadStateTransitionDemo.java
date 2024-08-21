class TransitionThread extends Thread {
    public void run() {
        System.out.println("Thread is running.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
            if (i == 2) {
                try {
                    System.out.println("Thread is sleeping.");
                    Thread.sleep(1000);  // Puts the thread in TIMED_WAITING state
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadStateTransitionDemo {
    public static void main(String[] args) {
        TransitionThread thread = new TransitionThread();
        System.out.println("Thread state: " + thread.getState());  // NEW
        thread.start();
        System.out.println("Thread state after start: " + thread.getState());  // RUNNABLE

        try {
            Thread.sleep(200);
            System.out.println("Thread state during execution: " + thread.getState());  // RUNNABLE or TIMED_WAITING

            thread.join();
            System.out.println("Thread state after completion: " + thread.getState());  // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
