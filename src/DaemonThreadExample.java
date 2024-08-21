class DaemonThread extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("This is a daemon thread.");
        } else {
            System.out.println("This is a user thread.");
        }
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        DaemonThread userThread = new DaemonThread();


        daemonThread.setDaemon(true);  // Set as daemon thread

        daemonThread.start();
        userThread.start();

    }
}
