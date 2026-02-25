package Queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer1 implements Runnable{
    private BlockingQueue<Integer> queue;
    private int value = 0;

    public  Producer1(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Producer produced :" + value);
                queue.offer(value++);
                Thread.sleep(1000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupt");

            }
        }

    }
}
class Consumer1 implements Runnable{
    private BlockingQueue<Integer> queue;
  //  private int value = 0;

    public  Consumer1(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer value = queue.take();
                System.out.println("Consumer consumed :" + value);
                Thread.sleep(2000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("consumer interrupt");

            }
        }

    }
}
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(5);
        Thread producer1 = new Thread(new Producer1(queue1));
        Thread consumer1 = new Thread(new Consumer1(queue1));
        producer1.start();
        consumer1.start();

    }
}
