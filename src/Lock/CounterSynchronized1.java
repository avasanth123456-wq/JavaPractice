package Lock;

public class CounterSynchronized1 {

    private  long count =0;

    private synchronized void inc(){
        this.count++;
    }

    public synchronized long getCount (){
        return this.count;
    }
}
