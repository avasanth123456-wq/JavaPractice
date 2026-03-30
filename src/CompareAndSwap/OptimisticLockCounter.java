package CompareAndSwap;

//import Volatile.Counter;

import Volatile.Counter;

import java.util.concurrent.atomic.AtomicLong;

public class OptimisticLockCounter extends Counter {
    private AtomicLong count = new AtomicLong();

    public boolean inc(){
        boolean incSuccessful = false;
        while (!incSuccessful){
            long value = this.count.get();
            long newValue = value + 1;

            incSuccessful = this.count.compareAndSet(value,newValue);

        }

        return incSuccessful;
    }
    public long getCount(){return this.count.get();}
}
