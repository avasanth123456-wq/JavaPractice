package JavaMemoryModel2;

import java.awt.Frame;

public class FrameExchangerTest {

    public static void main(String[] args) {

        FrameExchanger exchanger = new FrameExchanger();

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                Frame frame = new Frame("Frame " + i);

                exchanger.storeFrame(frame);

                System.out.println("Stored: " + frame.getTitle());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                Frame frame = exchanger.takeFrame();

                System.out.println("Taken: " + frame.getTitle());

            }

        });

        producer.start();
        consumer.start();
    }
}


