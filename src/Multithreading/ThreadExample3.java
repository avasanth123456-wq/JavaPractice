package Multithreading;

public class ThreadExample3{
    public  static  class MyRunnable implements Runnable{
        @Override
        public  void run(){
            System.out.println("MyThread Running");
            System.out.println("MyThread Finished");
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

    }
}
