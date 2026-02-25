package Queue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        queue.add("apple");
        queue.add("orange");
        queue.add("banana");
        queue.add("gauva");
        System.out.println(queue);
    }
}
