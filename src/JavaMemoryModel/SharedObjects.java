package JavaMemoryModel;

public class SharedObjects {
    static void main() {
        //SeparateObjects.MyObject myObject = new MyObject();

        Runnable runnable = new MyRunnable();
       // Runnable runnable2= new MyRunnable(myObject);


        Thread thread1 = new Thread(runnable, "Thread1");
        Thread thread2 = new Thread(runnable, "Thread2");

        thread1.start();
        thread2.start();
    }
}
