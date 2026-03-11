package RaceConditions;


import Volatile.Counter;

public class RaceConditionsExample4{
    static void main() {

        Counter1 counter1= new Counter1();
        Counter1 counter2= new Counter1();

        Thread thread1 = new Thread(getRunnable(counter1,counter2,"Thread1 "));
        Thread thread2= new Thread(getRunnable(counter2,counter1,"Thread2 "));

        thread1.start();
        thread2.start();
    }

    private  static Runnable getRunnable(Counter1 counterA, Counter1 counterB,String runnableName){
        return () ->{
            for(int i=0; i<1_000_000;i++){
                counterA.incAndGet();
                //System.out.println(counterB.get());

            }

            System.out.println(runnableName+"final count-counterA:" + counterA.get());
            System.out.println(runnableName+"final count-counterB:" + counterB.get());
        };
    }
}
