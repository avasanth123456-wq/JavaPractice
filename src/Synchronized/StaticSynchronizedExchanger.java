package Synchronized;

public class StaticSynchronizedExchanger {

    private static Object object = null;

    public static synchronized void setObject(Object o) {
        object = o;

    }

    public static synchronized Object getObject() {
        return object;
    }

    public static void setObj(Object o) {
        synchronized (StaticSynchronizedExchanger.class) {
            object = o;
        }
    }

    public static Object getObj() {
        synchronized (StaticSynchronizedExchanger.class) {
            return object;
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            setObject("Hello from Thread1");
            System.out.println("Thread1 set value");
        });

        Thread t2 = new Thread(() -> {
            Object value = getObject();
            System.out.println("Thread2 got value: " + value);
        });
     t1.start();
    t2.start();
    }
}