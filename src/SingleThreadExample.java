public class SingleThreadExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task " + i + " - Start");
            try {
                Thread.sleep(1000);  // Simulate a long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task " + i + " - End");
        }
    }
}

