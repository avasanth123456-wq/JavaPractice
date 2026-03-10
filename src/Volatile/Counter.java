package Volatile;

public class Counter {

    private volatile int count =0;

    public boolean inc(){
        if(this.count ==10){
            return false;
        }
        this.count++;
        return true;
    }

    static void main() {
        Counter counter = new Counter();

        while(counter.inc()){
            System.out.println("Counter increased");
        }

        System.out.println("Reached limit 10");
    }
}
