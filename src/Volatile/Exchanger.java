package Volatile;


public class Exchanger {

    private Object object = null;
    private volatile boolean hasNewObject = false;

    public void setObject(Object obj){
        this.object = obj;
        this.hasNewObject = true;
    }

    public Object getObject(){

        while(!this.hasNewObject){
            // busy wait
        }

        Object returnValue = this.object;
        this.hasNewObject = false;
        return returnValue;
    }

    public static void main(String[] args) {

        Exchanger exchanger = new Exchanger();

        // Producer Thread
        Thread producer = new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (Exception e) {}

            System.out.println("Producer sending object...");
            exchanger.setObject("Hello from Thread 1");

        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {

            System.out.println("Consumer waiting for object...");

            Object obj = exchanger.getObject();

            System.out.println("Consumer received: " + obj);

        });

        producer.start();
        consumer.start();
    }
}