package JavaMemoryModel;


public class TestThreads {

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
