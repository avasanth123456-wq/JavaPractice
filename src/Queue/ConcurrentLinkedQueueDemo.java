package Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // Add elements
        queue.add("Apple");
        queue.add("Banana");
        queue.offer("Mango");

        System.out.println("Queue: " + queue);

        // Remove element
        System.out.println("Removed: " + queue.poll());

        // Peek element
        System.out.println("Peek: " + queue.peek());

        System.out.println("Queue after operations: " + queue);
    }
}
