package Stream;


import java.time.Instant;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAllTopics {

    static void main() {
        List<Integer>list = Arrays.asList(5,2,8,1,3,2,4);
        // 1. Iterable vs Stream
        System.out.println("1.Iterable (External):");
        for(Integer i: list){
            System.out.print(i +"");
        }
        System.out.println("\n2. Stream(Internal):");
        list.stream().forEach(System.out::print);
        // 3. Lazy Evaluation
        System.out.println("\n\n3. Lazy Evaluation");
        Stream<Integer> lazy = list.stream()
                .filter(i->{
                    System.out.println("Filtering: " +i);
                   return i>2;
                })
                .map(i->{
                    System.out.println("Mapping: " + i);
                    return i*2;
                });
        System.out.println("No terminal -> nothing executed");
        lazy.count();
        // 4. Single-use Stream (Single Shot)
        System.out.println("\n4.single-use");
        Stream<Integer> s = list.stream();
        s.forEach(System.out::println);
        try{
            s.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error : " +e);
        }
        // 5. Intermediate Operations
        System.out.println("\n5. intermediate Ops.");
         list.stream()
                 .filter(i->i>2)
                 .map(i->i*2)
                 .sorted()
                 .distinct()
                 .limit(5)
                 .skip(1)
                 .peek(i->System.out.println("Peek :" +i))
                 .forEach(System.out::println);
        // 6. Terminal Operations
        System.out.println("/n6.Terminal operations:");

        long count = list.stream().count();
        System.out.println("count:" + count);

        Optional<Integer>first = list.stream().findFirst();
        first.ifPresent(x->System.out.println("First: " +x));


        boolean anyMatch = list.stream().anyMatch(i->i>6);
        System.out.println("Any > 6:" + anyMatch);

        boolean allMatch = list.stream().allMatch(i->i>0);
        System.out.println("all > 0:" + allMatch);

        boolean noneMatch = list.stream().noneMatch(i->i<0);
        System.out.println("none < 0:" + noneMatch);
        // 7. map vs flatMap
        System.out.println("n/7.flatmap:");

        List<List<Integer>> nested = Arrays.asList(
           Arrays.asList(1,2),
        Arrays.asList(3,4)
        );

         nested.stream()
                 .flatMap(Collection::stream)
                   .forEach(System.out::println);

        // 8. reduce
        System.out.println("n/8. reduce:");
        int sum = list.stream().reduce(0,Integer::sum);
        System.out.println("Sum :" + sum);

        // 9. collect
        System.out.println("n/9. Collect.");

        List<Integer> toList =
                list.stream().filter(i-> i>2).collect(Collectors.toList());

        Set<Integer> toSet =
                list.stream().collect(Collectors.toSet());

        Map<Integer,Integer> toMap =
                list.stream().distinct().collect(Collectors.toMap(i->i, i-> i*2));

        System.out.println("List: " + toList);
        System.out.println("Set: " + toSet);
        System.out.println("Map: " + toMap);

        // 10. groupingBy & partitioningBy
        System.out.println("n/10. grouping:");
        Map<Boolean,List<Integer>> partition =
                list.stream().collect(Collectors.partitioningBy(i->i%2 == 0));

        Map<Integer,List<Integer>> grouping =
                list.stream().collect(Collectors.groupingBy(i->i%2));

        System.out.println("Partition:" + partition);
        System.out.println("Grouping:" + grouping);

        // 11. Primitive Streams
        System.out.println("\n11. IntStream:");
        IntStream.range(1, 5).forEach(System.out::print);

        // 12. Short-circuit
        System.out.println("n/12. short circuit:");

        list.stream().filter(i->{
            System.out.println("checking:" +i);
            return i>3;

        })
                .findFirst();
        // 13. Parallel Stream
        System.out.println("n/13.Parallel Stream");
        list.parallelStream()
                .forEach(i->
                        System.out.println(Thread.currentThread().getName()+"->" + i));
        // 14. Infinite Stream
        System.out.println("n/14. Infinite Stream:");

        Stream.iterate(1, n-> n+1)
                .limit(5)
                .forEach(System.out::println);
        // 15. CopyOnWriteArrayList
        System.out.println("\n15. CopyOnWriteArrayList:");

        CopyOnWriteArrayList<Integer> cow = new CopyOnWriteArrayList<>(list);

        cow.stream().forEach(i -> {
            System.out.println("Reading: " + i);
            cow.add(100);
        });

        System.out.println("Final Size: " + cow.size());


    }
}