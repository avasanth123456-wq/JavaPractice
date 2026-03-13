package ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceExample8 {

    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future  future = executorService.submit(newCallable("Task 1.1"));

        System.out.println(future.isDone());

        boolean mayInterrupt =  false;
        boolean wasCancelled = future.cancel(mayInterrupt);
        System.out.println(wasCancelled);

        try{
            String result =  (String)  future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
        } catch  (ExecutionException e){
            String msg = "Cannot call Future.get() since task was cancelled";
            System.out.println(msg);

        }
        System.out.println(future.isDone());

        executorService.shutdown();
    }

    private static Callable newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }
}
