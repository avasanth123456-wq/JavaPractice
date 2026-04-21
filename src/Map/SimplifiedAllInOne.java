package Map;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class SimplifiedAllInOne {

    public static void main(String[] args) throws Exception{

        List<String> names = Arrays.asList("Vasanth","Vamika","Riju","Babu","Saidi");


        System.out.println("STREAM OPERATIONS");

        List<String> result= names.stream()
                .filter(name-> name.startsWith("V"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered Names:" + result);


        Map<Integer,List<String>> grouped =
                   names.stream().collect(Collectors.groupingBy(String::length));


        System.out.println("Grouped by Length :" + grouped);


        int totalLength = names.stream()
                .map(String::length)
                .reduce(0,Integer::sum);


        System.out.println("Total length:" + totalLength);


        System.out.println("MULTITHREADING");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () ->{
            System.out.println(Thread.currentThread().getName()+"is working :");

        };
        for(int i=0; i<5; i++){
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("PARALLEL STREAM ");

        names.parallelStream()
                .forEach(name->
                        System.out.println(Thread.currentThread().getName() + "->"+name)
                        );


        System.out.println("CONCURRENT MAP");

        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

        map.put("A",1);
        map.put("B",2);

        map.forEach((k,v)->
                System.out.println(Thread.currentThread().getName()+"  "+ k +"="+ v)
                );


           System.out.println(" PRODUCER-CONSUMER");

           BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

           Runnable producer = () ->{

               try{
                   for (int i=1; i<=5;i++){
                       queue.put(i);
                       System.out.println("Produced:"+i);
                   }
               }catch (Exception e){}

           };

           Runnable consumer = () ->{
               try{
                   for (int i=1; i<=5;i++){
                       int value = queue.take();
                       System.out.println("consumer:"+value);
                   }
               }catch (Exception e){}
           };

           new Thread(producer).start();
           new Thread(consumer).start();
    }
}
