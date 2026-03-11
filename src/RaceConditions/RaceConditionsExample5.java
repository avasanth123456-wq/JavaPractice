package RaceConditions;

import Volatile.Counter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RaceConditionsExample5 {
    static void main() {
        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (sharedMap) {
                    if (sharedMap.containsKey("key")) {
                        String val = sharedMap.remove("key");
                        if (val == null) {
                            System.out.println(
                                    "Iteration:" + i +
                                            ":value for 'key' was null");
                        }
                    } else {
                        sharedMap.put("key", "value");
                    }

                }

            }

        };
    }

}