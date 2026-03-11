package ThreadLocal;

public class InheritableThreadLocalBasicExample {
    static void main() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal=
                new InheritableThreadLocal<>();

        Thread thread1 = new Thread(()->{
            System.out.println("=====Thread 1====");
            threadLocal.set("Thread 1 - Threadlocal");
            inheritableThreadLocal.set("Thread 1 - InheritableThreadLocal");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(()->{
                System.out.println("==== ChildThread====");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());

            });
            childThread.start();

        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==== thread2====");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

        });
        thread2.start();
    }
}
