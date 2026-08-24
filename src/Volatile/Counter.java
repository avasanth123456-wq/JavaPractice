package Volatile;

public class Counter {

    private volatile int count = 0;

    public boolean inc() {
        if (this.count == 10) {
            return false;
        }
        this.count++;
        return true;
    }

    public static void main(String[] args) {

        Counter counter = new Counter();

        while (counter.inc()) {
            System.out.println("Counter incremented");
        }

        System.out.println("Reached limit 10");
    }

}