package Stream;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {

    public static void main(String[] args) {

        CopyOnWriteArraySet<Integer> copyOnwriteSet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        for (int i = 1; i <= 5; i++) {
            copyOnwriteSet.add(i);
            concurrentSkipListSet.add(i);
        }
        System.out.println("Initial CopyOnWriteArraySet: " + copyOnwriteSet);
        System.out.println("Initial ConcurrentSkipListSetSet: " + concurrentSkipListSet);


        System.out.println("\nIterating and modifying copyOnWriteArraySet:");
        for (Integer num : copyOnwriteSet) {
            System.out.println("Reading from copyOnWriteArraySet:" + num);
            copyOnwriteSet.add(6);
        }
        System.out.println(copyOnwriteSet);


        System.out.println("\nIterating and modifying concurrentSkipListSet:");
        for (Integer num : concurrentSkipListSet) {
            System.out.println("Reading from concurrentSkipListSet:" + num);
            if (num == 5) {
                concurrentSkipListSet.add(6);
            }
            System.out.println(concurrentSkipListSet);
        }
    }
}