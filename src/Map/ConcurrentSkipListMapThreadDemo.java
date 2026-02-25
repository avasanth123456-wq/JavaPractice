package Map;

import java.util.concurrent.ConcurrentSkipListMap;

public class   ConcurrentSkipListMapThreadDemo {

    public static void main(String[] args) {

        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                map.put(i, "T1-" + i);
                System.out.println("Thread-1 added: " + i);
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                map.put(i, "T2-" + i);
                System.out.println("Thread-2 added: " + i);
            }
        });

        // Start threads
        t1.start();
        t2.start();

        // Wait threads to finish
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Sorted Map: " + map);
    }
}
