package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class StreamMultithreadingFullExample {

    static void main() {
        List<Integer> numbers = Arrays.asList(10,20,30,40,50,60,70,80,90);

        System.out.println("====Parallel Stream Processing====");

        List<Integer> result = numbers.parallelStream().
                filter(n->{
                    System.out.println("Filter: "+ n  +   "Thread:" +Thread.currentThread().getName()) ;
                    return n > 25;
                })
                .map(n->{
                    System.out.println("Map: "+ n  +   "Thread:" +Thread.currentThread().getName()) ;
                    return n * 25;
                })
                .distinct()
                .sorted()
                .peek(n->System.out.println("Peek:" +n+"Thread:" +Thread.currentThread().getName()))
                .limit(5)
                .collect(Collectors.toList());
           System.out.println("Final Result:" +result);

           int sum = numbers.parallelStream()
                   .reduce(0,Integer::sum);

           System.out.println("Sum(Reduce):" + sum);

        Map<String,List<Integer>> grouped =
                numbers.parallelStream()
                        .collect(Collectors.groupingBy(n-> n%2 == 0 ?"Even":"Odd"));

        System.out.println("Grouped:" +grouped);


        System.out.println("\n=== ExecutorService + Stream ===");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(()->{
            numbers.stream()
                    .map(n-> {
                        System.out.println("Executor Thread: " + Thread.currentThread().getName());
                        return n * 3;
                    })
                    .forEach(System.out::println);
        });
        executor.shutdown();
    }
}
