package ThreadSingaling;

public class SignalCarrier {

    public void doWait() throws InterruptedException{
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"calling wait()");
            this.wait();
            System.out.println(Thread.currentThread().getName()+"exital wait()");
        }
    }
    public void doNotify(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"calling notify()");
            this.notify();
            System.out.println(Thread.currentThread().getName()+"exital notify()");
        }
    }
    public void doNotifyAll(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"calling notify()");
            this.notifyAll();
            System.out.println(Thread.currentThread().getName()+"exital notify()");
        }
    }
}
