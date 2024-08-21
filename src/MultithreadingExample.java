
class Task implements Runnable {
    private int taskId;

    public Task(int id) {
        this.taskId = id;
    }

    public void run() {
        System.out.println("Task " + taskId + " - Start");
        try {
            Thread.sleep(1000);  // Simulate a long task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " - End");
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(1));
        Thread t2 = new Thread(new Task(2));
        Thread t3 = new Thread(new Task(3));

        t1.start();
        t2.start();
        t3.start();
    }
}

