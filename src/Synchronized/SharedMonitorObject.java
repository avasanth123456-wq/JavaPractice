package Synchronized;

public class SharedMonitorObject {

    private Object monitor = null;

    private int counter = 0;

    public SharedMonitorObject(Object monitor){
        if(monitor == null){
            throw  new IllegalArgumentException(
                    "Monitor object cannot be null"
            );
        }
        this.monitor = monitor;
    }
    public  void incCounter(){
        synchronized (this.monitor){
            this.counter++;
        }

    }
    public int getCounter(){
        return counter;
    }


    public static void main(String[] args){
        Object monitor1 = new Object();

        SharedMonitorObject smo1=
                new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2=
                new SharedMonitorObject(monitor1);

        smo1.incCounter();
        smo2.incCounter();

        Object monitor2 = new Object();
        SharedMonitorObject smo3=
                new SharedMonitorObject(monitor2);

        smo3.incCounter();

        System.out.println("smo1 counter: " + smo1.getCounter());
        System.out.println("smo2 counter: " + smo2.getCounter());
        System.out.println("smo3 counter: " + smo3.getCounter());
    }
}
