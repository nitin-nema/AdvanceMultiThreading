class Resource {
    synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + " locked methodA");
    }

    synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " locked methodB");
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource res1 = new Resource();
        Resource res2 = new Resource();

        //Dead lock situation
//        Runnable task1 = () -> res1.methodA(res2);
//        Runnable task2 = () -> res2.methodA(res1);

        //Define lock ordering to prevent deadlock
        Runnable task1 = () -> {
            synchronized (res1) { // Lock resource 1 first
                System.out.println(Thread.currentThread().getName() + " locked the res1");
                synchronized (res2) {  // then Lock the resouce 2
                    System.out.println(Thread.currentThread().getName() + "locked res2");
                    res1.methodA();
                }
            }
        };

        Runnable task2 =() -> {
            synchronized (res1) { // Lock resource 1 first
                System.out.println(Thread.currentThread().getName() + " locked the res1");
                synchronized (res2) {  // then Lock the resouce 2
                    System.out.println(Thread.currentThread().getName() + "lokced res2");
                    res2.methodB();
                }
            }
        };


        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();
    }
}
