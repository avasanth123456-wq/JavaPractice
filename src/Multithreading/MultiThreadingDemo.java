package Multithreading;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

class Order{
    int id;
    double amount;

    Order(int id, double amount){
        this.id = id;
        this.amount = amount;

    }
}

  class  OrderProcesser implements  Runnable{
    private  Order order;

    OrderProcesser(Order order){
        this.order = order;
    }
    @Override
      public void  run(){
        System.out.println(Thread.currentThread().getName()+
                "Processing Order:"+ order.id);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println("Completed Order:" + order.id);
    }
  }

public class MultiThreadingDemo {

    private static int totalProcessed =0;
    public static synchronized void  increment(){
        totalProcessed++;
    }
  public   static void main(String[] args)  throws Exception{
      List<Order> orders = Arrays.asList(
              new Order( 1,100),
              new Order( 2,200),
              new Order( 3,300),
              new Order( 4,400),
              new Order( 5,500)
      );
      System.out.println("==== Using Thread class====");
      Thread t1 = new Thread(new OrderProcesser(orders.get(0)));
      t1.start();
      t1.join();


      System.out.println("==== Using Runnable ====");
      Thread t2= new Thread(new OrderProcesser(orders.get(1)));
      t2.start();
      t2.join();

      System.out.println("using Executor Service(Thread pool)");
      ExecutorService executor = Executors.newFixedThreadPool(3);


      for (Order order: orders){
          executor.submit(()->{
              System.out.println(Thread.currentThread().getName()
              +"Processing Order:" +order.id);

              increment();

              try{
                  Thread.sleep(300);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          });
      }
       executor.shutdown();
      executor.awaitTermination(5, TimeUnit.SECONDS);

      System.out.println("Total Processed (Sync):" + totalProcessed);


      System.out.println("====using parallel stream====");
      orders.parallelStream().forEach(order -> {
          System.out.println(Thread.currentThread().getName()
          + "Parallel Processing"+ order.id);
      });
      System.out.println("====Using CompletableFuture====");
      List<CompletableFuture<Void>> futures = orders.stream()
              .map(order -> CompletableFuture.runAsync(()->{
                  System.out.println(Thread.currentThread().getName()
                  +"Async processing:" + order.id);
      }))
              .collect(Collectors.toList());

      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

      System.out.println("===== ALL TASKS COMPLETED =====");

    }
}
