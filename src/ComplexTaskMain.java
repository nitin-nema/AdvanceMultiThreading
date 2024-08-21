class ComplexTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ComplexTaskMain {
    public static void main(String[] args) {
        //named to t1, t2
//        Thread t1 = new Thread(new ComplexTask(),"t1");
//        Thread t2 = new Thread(new ComplexTask(),"t2");
        Thread t1 = new Thread(new ComplexTask());
        t1.setName("Custom-thread-1");

        Thread t2 = new Thread(new ComplexTask());
        t2.setName("Custom-thread-2");


        t1.start();
        t2.start();
    }
}

