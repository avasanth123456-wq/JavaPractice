package Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CLQThreadExample {

    static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        // Producer Thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.add(i);
                System.out.println("Produced: " + i);
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            while (true) {
                Integer value = queue.poll();
                if (value != null) {
                    System.out.println("Consumed: " + value);
                }
                if (queue.isEmpty()) break;
            }
        });

        producer.start();
        consumer.start();
    }
}
