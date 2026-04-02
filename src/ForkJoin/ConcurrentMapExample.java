package ForkJoin;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {

    public static void main(String[] args) {

        Map hashmap = new HashMap();
        Map hashTable = new Hashtable();
        Map map = new ConcurrentHashMap();
        Map concurrentMap = new ConcurrentHashMap();


        concurrentMap.put("Key", "Value");
        Object object = concurrentMap.get("Key");

        ConcurrentHashMap<String, String> concurrentMap2 = new ConcurrentHashMap<>();
        concurrentMap2.put("Key2", "value2");
        String value2 = concurrentMap2.get("Key");


        concurrentMap2.remove("Key");


        Iterator<String> iterator = concurrentMap2.keySet().iterator();
        while (iterator.hasNext()) {

        }
        //slipped conditions
        if (!concurrentMap2.containsKey("key")) {
            concurrentMap2.put("key2", "value2");
        }
        //fix for slipped conditions
        concurrentMap2.putIfAbsent("Key2", "value2");

        concurrentMap2.computeIfAbsent("key", (key) -> {
          System.out.println("absent key :" + key);
          //System.out.println("value class:" + val.getClass());
          return "val2";

        });
    }
}