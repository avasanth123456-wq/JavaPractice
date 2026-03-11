package RaceConditions;

public  class RaceConditionsExample3 {
    static void main() {
        Counter1 counter = new Counter1();
        Thread thread1 = new Thread(getIncrementingRunnable(counter));
        Thread thread2 = new Thread(getReadingRunnable(counter));

        thread1.start();
        thread2.start();
    }

    private static Runnable getIncrementingRunnable(Counter1 counter) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incAndGet();

            }
            System.out.println("Thread1 final count" + counter.get());
        };
    }

    private static Runnable getReadingRunnable(Counter1 counter) {
        return () -> {
            for (int i = 0; i < 5; i++) {
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Thread2 count" + counter.get());
        };
    }
}