package BlockingQueue;

import java.util.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<String> blockingQueue= null;

    public Consumer(BlockingQueue<String> queue){
        this.blockingQueue=queue;
    }
    @Override
    public void run() {
        while (true){
            try{
                String element =
                        this.blockingQueue.take();
                System.out.println("consumed:" + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


/*class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = queue.take();
                System.out.println("Consumed: " + item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}*/
