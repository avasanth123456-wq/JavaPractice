package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Order implements Comparable<Order>{
    int id;
    String product;
    double price;

    public Order( int id, String product, double price){
        this.id=id;
        this.product=product;
        this.price=price;
    }
    @Override
    public  int compareTo(Order o){
        return Double.compare(o.price, this.price);
    }
    @Override
    public  String toString(){
        return "Order{id=" +id+", Product='" + product+"' price="+price+"}";
    }
}

class OrderProcessor implements Runnable{
    private Order order;

    public OrderProcessor(Order order){
        this.order =order;
    }
    @Override
    public void  run(){
        System.out.println(Thread.currentThread().getName()+
                "Processing:"+order);

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ComparableMultithreadingDemo {

    public static void main(String[] args) throws  Exception{
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1,"Laptop",80000));
        orders.add(new Order(2,"Mobile",70000));
        orders.add(new Order(3,"charge",3000));
        orders.add(new Order(4,"headphone",5000));
        orders.add(new Order(5,"Keyboard",2000));

        Collections.sort(orders);

        System.out.println("Sorted Orders(High ->Low Price):");
        orders.forEach(System.out::println);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Order order : orders){
            executor.submit(new OrderProcessor(order));
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);


        System.out.println("All Orders Processed!");

    }
}
