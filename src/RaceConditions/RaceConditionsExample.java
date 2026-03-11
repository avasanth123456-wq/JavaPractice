package RaceConditions;

import Volatile.Counter;

public class RaceConditionsExample {
    static void main() {
        Counter1 counter= new Counter1();
        Thread thread1 = new Thread(getRunnable(counter,"Thread1 final count: "));
        Thread thread2= new Thread(getRunnable(counter,"Thread1 final count: "));

        thread1.start();
        thread2.start();
    }

    private  static Runnable getRunnable(Counter1 counter, String message){
        return () ->{
            for(int i=0; i<1_000_000;i++){
                counter.incAndGet();

            }
            System.out.println(message + counter.get());
        };
    }
}
