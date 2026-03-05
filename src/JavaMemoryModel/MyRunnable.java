package JavaMemoryModel;

public  class MyRunnable implements Runnable {

    private int count = 0;



    @Override
    public void run() {
       // MyObject myObject = new MyObject();
       // System.out.println(myObject);

        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                this.count++;
            }
        }
        System.out.println(
                Thread.currentThread().getName()
                +":" + this.count);
    }
}

 /*  public static void main() {



        MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        thread1.start();
        thread2.start();
    }*/
