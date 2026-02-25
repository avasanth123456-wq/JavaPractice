package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static  void  main (String[] args){

        //1.filter
        List<String> list = Arrays.asList("Akshit","Ram","Shyam","Ghanshyam");
        Stream<String> filteredStram = list.stream().filter(x ->x.startsWith("A"));
        //no filtering at this point
        long res = list.stream().filter(x->x.startsWith("A")).count();
        System.out.println(res);

        //2.map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        //3.sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a,b) -> a.length() - b.length());

        //4.distinct
        System.out.println(list.stream().filter(x-> x.startsWith("A")).distinct().count());
        //5.limit
        System.out.println(Stream.iterate(1,x->x+1).limit(100).count());
        //6.skip
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(100).count());
        //7.peek
        Stream.iterate(1,x->x+1).skip(10).limit(100).peek(System.out::println).count();
        //8.flatMap
           List<List<String>>listofLists = Arrays.asList(
           Arrays.asList("apple","banana"),
           Arrays.asList("orange","kiwi"),
          Arrays.asList("pear","grape")
);
        System.out.println(listofLists.get(1).get(1));
        System.out.println(listofLists.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java strams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(""))).map(String::toUpperCase).toList());

    }
}
