package Map;

import java.util.*;

public class MapComparisonExample {

  public   static void main(String[] args) throws InterruptedException {

      System.out.println("HashMap");

      Map<Integer,String> hashMap = new HashMap<>();
      hashMap.put(3,"C");
      hashMap.put(1,"A");
      hashMap.put(2,"B");

      System.out.println("HashMap,( No Order):" +hashMap);



      System.out.println("LinkedHashMap");
      Map<Integer,String> linkedhashMap = new LinkedHashMap<>();
      linkedhashMap.put(3,"C");
      linkedhashMap.put(1,"A");
      linkedhashMap.put(2,"B");


      System.out.println("LinkedHashMap (Insertion Order):" + linkedhashMap);


      System.out.println("WeakHashMap");
      Map<Object,String> weakHashMap = new WeakHashMap<>();

      Object key1 = new String("Key1");
      Object key2 = new String("Key2");


      weakHashMap.put(key1,"Value1");
      weakHashMap.put(key2,"Value2");

      System.out.println("Before GC:" + weakHashMap);

      key1 = null;

      System.gc();
      Thread.sleep(1000);

      System.out.println("After GC (key1 may be remove):" + weakHashMap);

      System.out.println("identityHashMap");
      Map<String,String> identityHashMap = new IdentityHashMap<>();

      String k1 = new String("Key");
      String k2 = new String("Key");

      identityHashMap.put(k1,"Value1");
      identityHashMap.put(k2,"value2");

      System.out.println("IdentityHashmap (Reference Comparsion):" +identityHashMap);


      Map<String,String> normalHashMap = new HashMap<>();
      normalHashMap.put(k1,"value");
      normalHashMap.put(k2,"value");


      System.out.println("HashMap (Equals Comparsion):" +normalHashMap);
    }
}
