package Synchronized;

public class Reentrance {

    private int count =0;

    public synchronized void inc(){
        this.count++;
    }
    public synchronized int incAndGet(){
        inc();
        return this.count;
    }
    public static void main(String[] args){

        Reentrance obj = new Reentrance();

        int value = obj.incAndGet();

        System.out.println("Counter value: " + value);
    }
}
