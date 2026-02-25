package Collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CollectionsList {

    public  static  void main (String[] args){

        int [] arr = { 100,200,300};
        System.out.println("Array");
         for (int a:arr){
             System.out.println(a);
         }

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("\nArrayList:");
        System.out.println(arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("CoreJava");
        linkedList.add("SpringBoot");
        linkedList.add("React");

        System.out.println("\nLinkedList:");
        System.out.println(linkedList);

        Vector<Integer> vector = new Vector<>();
        vector.add(200);
        vector.add(400);
        vector.add(600);
        System.out.println("\nVector:");
        System.out.println(vector);

        Stack<String> stack = new Stack<>();
         stack.push("one");
         stack.push("Two");
         stack.push("Three");
        System.out.println("\nStack:");
        System.out.println(stack);
        System.out.println("Pop from  stack" + stack.pop());

        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
            cowList.add("A");
            cowList.add("B");
            cowList.add("c");

            for (String s: cowList){
                if(s.equals("B")){
                    cowList.add("D");
                }
            }
        System.out.println("\ncowList:");
        System.out.println(cowList);

    }
}
