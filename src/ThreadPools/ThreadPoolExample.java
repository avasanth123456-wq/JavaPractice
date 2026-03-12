package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 6; i++) {
            int taskId = i;

            executor.execute(() -> {
                System.out.println(
                        "Executing Task " + taskId +
                                " by " + Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
