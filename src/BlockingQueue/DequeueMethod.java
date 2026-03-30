package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DequeueMethod {
    public static void main(String[] args) {
        BlockingQueue<String > blockingQueue =
                new ArrayBlockingQueue<>(3);
        //take() blocks until an element becomes avaiable
        try{
            String element = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //poll() returns null if no element is available
        String element2 = blockingQueue.poll();
        //poll (long timeout,TimeUnit time unit) blocks up until timeout
        //for  element to become available.if no element is avialable
        //before that time ,null is returned
        try{
            String element3 = blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //removes the element if present in the blockingQueue
        boolean wasrRemoved = blockingQueue.remove("1");
    }
}
