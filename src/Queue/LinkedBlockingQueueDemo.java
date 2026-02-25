package  Queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    BlockingQueue<String> queue;

    Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String item = "Item " + i;
                queue.put(item);   // waits if full
                System.out.println("Produced: " + item);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    BlockingQueue<String> queue;

    Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                String item = queue.take();  // waits if empty
                System.out.println("Consumed: " + item);
                Thread.sleep(800);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}