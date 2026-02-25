package Stream;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    public static void main(String[] args){
        NavigableSet<Integer> set =new TreeSet<>();
        set.add(12);
        set.add(1);
        set.add(1);
        set.add(67);
        System.out.println(set);
        System.out.println(set.contains(23));
        System.out.println(set.remove(67));
        set.clear();
        System.out.println(set.isEmpty());
        for(int i :set){
            System.out.println(i);
        }
        //for thread safety
        Set<Integer> set1 = new ConcurrentSkipListSet<>();
        System.out.println(set1);

      //  Set<Integer> syncSet = Collections.synchronizedSet(new TreeSet<>());
    //    synchronized (syncSet){
       //     for(Integer i:syncSet){
                //safe iteration
            //    System.out.println(i);
       //     }
      //  }
        Set<Integer> integers = Set.of(1,2,3,4,5,6,7,8,9,54,4323,545,4545);
        System.out.println(integers);
    }
}
