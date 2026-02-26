package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.addFirst(10);
        deque1.addLast(20);
        deque1.addFirst(5);
        deque1.addLast(25);
        //5,10,20,25
        System.out.println(deque1);
        System.out.println("First Element:"+ deque1.getFirst());
        System.out.println("Last Element:"+ deque1.getLast());
        deque1.removeFirst();// remove 5
        deque1.pollLast();// removes 25
        //current deque[10,20]
        for(int num : deque1){
            System.out.println(num);
        }
        Deque<Integer> deque2 = new LinkedList<>();// insertion,delection somewhere in middle
        deque1.remove(10);
        System.out.println(deque2);
    }
}
