package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
   /*     LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);//enqeueue
        list.addLast(2);//enqueue
        list.addLast(3);//enqueue
        System.out.println(list);
    Integer   i =list.removeFirst(); //dequeue
    System.out.println(list);
    list.peekFirst();//peek*/

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        System.out.println(queue1.size());

      //  System.out.println(queue1.remove());// throws exception if empty
        System.out.println(queue1.poll());

       // System.out.println(queue1.element());// throws exception if empty
        System.out.println(queue1.peek());

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1));// true
        System.out.println(queue2.offer(2));// true

       // System.out.println(queue2.offer(3));//Throws exception
        System.out.println(queue2.offer(3));//false


    }

}
