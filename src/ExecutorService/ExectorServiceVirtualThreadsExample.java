package ExecutorService;

import java.util.concurrent.*;

public class ExectorServiceVirtualThreadsExample {

    static void main() {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        executor.submit(()->{
           System.out.println("This is aRunnable that is executed  by a virtual thread");
        });

        Callable<String> callable = new Callable<>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable executed by virtual thread");
                return "Result from Callable";
            }
        };

        Future<String> futureResult = executor.submit(callable);

        try{
            System.out.println(futureResult.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        try{
            executor.awaitTermination(10,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
