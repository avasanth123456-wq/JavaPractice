package Stream;

import java.util.concurrent.CopyOnWriteArraySet;

public class Copy{

    public static void main(String[] args) {

        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        // Thread 1 → Reading
        Thread t1 = new Thread(() -> {
            for (Integer num : set) {
                System.out.println("Reading: " + num);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        });

        // Thread 2 → Writing
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {}

            System.out.println("Adding: 4");
            set.add(4);
        });

        t1.start();
        t2.start();
    }
}

