package ExecutorService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample1 {

    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 3000;

        ExecutorService threadPoolExecutor =

                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(128)
                );
        threadPoolExecutor = (threadPoolExecutor);
        Executors.newFixedThreadPool(3);

        ExecutorService scheduledExecutorService =
                new ScheduledThreadPoolExecutor(corePoolSize);

        scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
    }

    private static Runnable newRunnable(String msg) {
        return new Runnable() {

            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + msg);

            }
        };
    }


}