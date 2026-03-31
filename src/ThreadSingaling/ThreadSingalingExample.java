package ThreadSingaling;

public class ThreadSingalingExample {

    public static void main(String[] args) {

       // SignalCarrier signalCarrier = new SignalCarrier();
       // SingalHolder singalHolder = new SingalHolder();
          SignalCounter signalCounter = new SignalCounter();
        Thread waiter = new Thread(()->{
            try{
                //signalCarrier.doWait();
                //singalHolder.doWait();
                signalCounter.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread notifier = new Thread(()->{
            //signalCarrier.doNotify();
           // singalHolder.doNotify();
            signalCounter.doNotify();
        });
        notifier.start();
        waiter.start();

    }
}
