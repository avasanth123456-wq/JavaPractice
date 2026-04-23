package Map;
import java.util.*;
import java.util.concurrent.*;


class Order {
    private String product;

    public Order(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}


class OrderProcessor implements Runnable {
    private Order order;
    private ConcurrentHashMap<String, Integer> productCountMap;

    public OrderProcessor(Order order,
                          ConcurrentHashMap<String, Integer> productCountMap) {
        this.order = order;
        this.productCountMap = productCountMap;
    }

    @Override
    public void run() {
        String product = order.getProduct();

        // Thread-safe update
        productCountMap.merge(product, 1, Integer::sum);

        System.out.println(Thread.currentThread().getName() +
                " processed: " + product);
    }
}


public class ConcurrentHashMapExample{

    public static void main(String[] args) throws Exception {


        ConcurrentHashMap<String, Integer> productCountMap =
                new ConcurrentHashMap<>();


        List<Order> orders = Arrays.asList(
                new Order("Virat"),
                new Order("Dhoni"),
                new Order("Virat"),
                new Order("Rohit"),
                new Order("Dohni"),
                new Order("Virat")
        );

        // Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks
        for (Order order : orders) {
            executor.submit(new OrderProcessor(order, productCountMap));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Final Result
        System.out.println("Final Product Count:");
        productCountMap.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }
}
