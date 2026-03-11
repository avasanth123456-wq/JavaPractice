package ThreadLocal;

public class ThreadLocalRemoveExample {

    static void main() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread thread1 = new Thread(()->{
            threadLocal.set("Thread 1");

            String value = threadLocal.get();
            System.out.println(value);

            threadLocal.remove();
            value= threadLocal.get();
            System.out.println(value);

        });
        Thread thread2 = new Thread(()->{
            threadLocal.set("Thread 1");

            String value = threadLocal.get();
            System.out.println(value);
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            value = threadLocal.get();
            System.out.println(value);

            threadLocal.remove();
            value=threadLocal.get();
            System.out.println(value);

        });

        thread1.start();
        thread2.start();
    }
}
