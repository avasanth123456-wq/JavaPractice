package Queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);
        System.out.println(pq);//not stored
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

}
