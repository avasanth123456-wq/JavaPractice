package Stream;

import java.util.*;

class MyNumbers implements Iterable<Integer> {

    private List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}

public class IterableDemo {
    public static void main(String[] args) {

        MyNumbers myNumbers = new MyNumbers();

        //  for-each works because class is Iterable
        for (int n : myNumbers) {
            System.out.println(n);
        }
    }
}

