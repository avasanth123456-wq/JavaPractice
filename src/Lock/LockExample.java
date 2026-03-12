package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args){
        Lock lock = new ReentrantLock(true);

        lock.lock();

        lock.unlock();
    }
}
