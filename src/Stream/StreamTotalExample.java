package Stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class  Order{
    int id;
    String category;
    double amount;

    public Order(  int id, String category,double amount){
        this.id = id;
        this.category = category;
        this.amount = amount;

    }
    public String getCategory(){return  category;}
    public double getAmount(){return amount;}

    @Override
    public  String toString(){
        return "Order{id=" + id+", category="+category+", amount=" + amount +  "}";
    }
}

public class StreamTotalExample {

    static BlockingQueue<Order> queue = new ArrayBlockingQueue<>(10);
    public static void main (String[] args) throws Exception{

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable producer = () ->{
            try{
                for(int i =0; i<=10; i++){
                    Order order = new Order(
                            i,
                            i %2 == 0? "ELECTRONIC":"GROCERY",
                            ThreadLocalRandom.current().nextDouble(100,1000)
                    );
                    queue.put(order);
                    System.out.println("Producer:" +order);

                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        Runnable consumer = ()->{
            try{
                List<Order> batch = new ArrayList<>();

                while (true){
                    Order order =queue.poll(2,TimeUnit.SECONDS);
                    if (order== null) break;

                    batch.add(order);

                }
                System.out.println("\nProcessing Batch using Streams...\n");

                List<Order> expensiveOrders = batch.stream()
                        .filter(o-> o.getAmount()>500)
                        .collect(Collectors.toList());

                List<Double> amounts = expensiveOrders.stream()
                        .map(Order::getAmount)
                        .collect(Collectors.toList());


                double total = amounts.stream()
                        .reduce(0.0,Double::sum);

                Map<String,List<Order>> grouped =
                        batch.stream()
                                .collect(Collectors.groupingBy(Order::getCategory));

                double parallelTotal = batch.parallelStream()
                        .mapToDouble(Order::getAmount)
                        .sum();



                System.out.println("Expensive Orders (>500): " + expensiveOrders);
                System.out.println("Total (Filtered): " + total);
                System.out.println("Grouped Orders: " + grouped);
                System.out.println("Parallel Total: " + parallelTotal);



            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        executor.submit(producer);
        executor.submit(consumer);


        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

    }
}
