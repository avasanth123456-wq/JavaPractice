package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public  static  void main (String[] args){
        long startTime = System.currentTimeMillis();
        List<Integer > list = Stream.iterate(1, x-> x+1).limit(2000).toList();
        List<Long> factorialList =list.stream().map(ParallelStream::factorial).toList();
        long endTime=System.currentTimeMillis();
        System.out.println("Time taken with sequential stream:" +(endTime-startTime)+ "ms");


        startTime = System.currentTimeMillis();
       factorialList =list.stream().map(ParallelStream::factorial).toList();
         endTime=System.currentTimeMillis();
        System.out.println("Time taken with parallel stream:" +(endTime-startTime)+ "ms");


      //commulative sum
      //[1,2,3,4,5,] --> [1,3,6,10,15]
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativesum = numbers.parallelStream().map(sum::addAndGet).toList();
        System.out.println("Expected cumulative sum:[1,3,6,10,15]");
        System.out.println("Actual result with parallel stream:" + cumulativesum);


    }

    private  static long factorial(int n){
        long result =1;
         for ( int i=2; i<=n; i++){
             result*=i;
         }
         return result;
    }
}

