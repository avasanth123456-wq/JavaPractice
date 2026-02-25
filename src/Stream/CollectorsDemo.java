package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //Collectors is a utility class
        //provides a set of method to create common collectors

        //1.Collecting to alist
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        //2.Collecting to a set
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 4);
        List<Integer> set = nums.stream().collect(Collectors.toList());
        System.out.println(set);

        //3.Collecting to a Specific Collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println(collect);

        //4.joining Strings
        //Concatenates stream elements into a single String
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(concatenatedNames);

        //5.SummarizingData
        //Generate statistical summary(count,sum,min,average,max)
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count:" + stats.getCount());
        System.out.println("Min:" + stats.getMin());
        System.out.println("Sum:" + stats.getSum());
        System.out.println("getAverage:" + stats.getAverage());
        System.out.println("max :" + stats.getMax());

        //6.Calculating Averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

        //7.Counting Elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count:" + count);

        //8.Grouping Elements
        List<String> words = Arrays.asList("hello","world","java","streams","collecting");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(","))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        TreeMap<Integer,Long> treeMap =words.stream().collect(Collectors.groupingBy(String::length ,TreeMap:: new,Collectors.counting()));
        System.out.println(treeMap);

        //9.Partitionting Elements
        //Partitions elements into two groups(true and false) based on predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5)));

        //10.Mapping and collecting
        //applies a mapping function before collecting
       System.out.println(words.stream().collect(Collectors.mapping(x->x.toUpperCase(),Collectors.toList())));
    }
}
