package Synchronized;

public class MultipleMonitorObjects {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    public void incCounter1(){
        synchronized (this.monitor1){
            counter1++;
        }
    }

    public void incCounter2(){
        synchronized (this.monitor2){
            counter2++;
        }
    }

    public int getCounter1(){
        return counter1;
    }

    public int getCounter2(){
        return counter2;
    }


        public static void main(String[] args) throws Exception {

            MultipleMonitorObjects obj = new MultipleMonitorObjects();

            Thread t1 = new Thread(() -> {
                for(int i = 0; i < 1000; i++){
                    obj.incCounter1();
                }
                System.out.println("Thread1 finished counter1");
            });

            Thread t2 = new Thread(() -> {
                for(int i = 0; i < 1000; i++){
                    obj.incCounter2();
                }
                System.out.println("Thread2 finished counter2");
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Counter1 = " + obj.getCounter1());
            System.out.println("Counter2 = " + obj.getCounter2());
        }
    }
