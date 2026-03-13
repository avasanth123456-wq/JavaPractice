package ExecutorService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample7 {
    static void main() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.shutdown();

        List<Runnable> runnables = executorService.shutdownNow();

        //System.out.println();

        try{
            executorService.awaitTermination(
                    3000l, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
