package Synchronized;

public class MixedSynchronization {
    public static Object staticObj = null;

    public static synchronized void setStaticObj(Object obj) {
        staticObj = obj;
    }

    public Object instanceObj = null;

    public synchronized void setInstanceObj(Object obj) {
        this.instanceObj = obj;
    }

    public static void main(String[] args) {

        MixedSynchronization obj = new MixedSynchronization();

        Thread t1 = new Thread(() -> {
            MixedSynchronization.setStaticObj("Static Value");
            System.out.println("Thread1 set static object");
        });

        Thread t2 = new Thread(() -> {
            obj.setInstanceObj("Instance Value");
            System.out.println("Thread2 set instance object");
        });

        t1.start();
        t2.start();
    }
}