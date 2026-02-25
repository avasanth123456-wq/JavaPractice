package Map;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void  main (String[] args){
       //SortedMap<Integer,String> map = new TreeMap<>();
        //map.put(91,"vivek");
        //map.put(99,"Shubham");
        //map.put(78,"Mohit");
        //map.put(77,"vipul");
       // System.out.println(map);
      // map.get(77);
       //map.containsKey(78);
      // map.containsValue(77);

       // System.out.println(map.firstKey());
       // System.out.println(map.lastKey());
       // System.out.println(map.headMap(91));
        //System.out.println(map.tailMap(91));
        //map.subMap(78,91);

        NavigableMap<Integer,String> navigableMap = new TreeMap<>();
        navigableMap.put(1,"one");
        navigableMap.put(5,"Five");
        navigableMap.put(3,"Three");
        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(2));
        System.out.println(navigableMap.ceilingKey(3));
    }
}
