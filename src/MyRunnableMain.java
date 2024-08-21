class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable is running.");
    }
}
public class MyRunnableMain {
    public static void main(String[] args){
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

    }
}
