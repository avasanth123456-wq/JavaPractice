package ExecutorService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
     public static void main (String[] args){
    ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Task1"));
         executorService.execute(newRunnable("Task2"));
         executorService.execute(newRunnable("Task3"));

         executorService.shutdown();

            }

            private static Runnable newRunnable(String msg) {
                return new Runnable() {
                    @Override
                    public void run() {

                        String completeMsg =
                                Thread.currentThread().getName()+
                                        ":" + msg;
                        System.out.println(completeMsg);
                    }

                };

            }
}