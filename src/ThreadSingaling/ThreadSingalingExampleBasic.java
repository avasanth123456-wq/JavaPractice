package ThreadSingaling;

public class ThreadSingalingExampleBasic {


    public static void main(String[] args) {

        Object singalObject = new Object();

        Thread waitingThread = new Thread(()->{
            synchronized (singalObject){
                try{
                    singalObject.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    });
        Thread notifyingThread = new Thread(()->{
            synchronized (singalObject){
                singalObject.notify();
            }

        });
        waitingThread.start();
        notifyingThread.start();
    }
}
