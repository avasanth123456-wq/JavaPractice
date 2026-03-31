package ThreadSingaling;

/*public class SpuriousWakeUpSingalGuard {


  // public static void main(String[] args) {

        Object myMonitorObject = new Object();
        boolean wasSignalled = false;


        public void doNotify () {
            synchronized (myMonitorObject) {
                wasSignalled = true;
                myMonitorObject.notify();

            }
        }

        public void doWait () throws InterruptedException {
            synchronized (myMonitorObject) {
                while (!wasSignalled) {
                    myMonitorObject.wait();

                }
                //clear signal and continue running
                wasSignalled = false;

            }

        }
    }*/


public class SpuriousWakeUpSingalGuard {

    private final Object myMonitorObject = new Object();
    private boolean wasSignalled = false;

    public void doNotify() {
        synchronized (myMonitorObject) {
            System.out.println(Thread.currentThread().getName() + " sending signal...");
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }

    public void doWait() throws InterruptedException {
        synchronized (myMonitorObject) {
            while (!wasSignalled) {
                System.out.println(Thread.currentThread().getName() + " waiting...");
                myMonitorObject.wait();
            }
            // clear signal
            wasSignalled = false;
            System.out.println(Thread.currentThread().getName() + " received signal!");
        }
    }

    // ✅ MAIN METHOD
    public static void main(String[] args) {

        SpuriousWakeUpSingalGuard signal = new SpuriousWakeUpSingalGuard();

        Thread waiter = new Thread(() -> {
            try {
                signal.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Waiter-Thread");

        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(2000); // simulate delay
                signal.doNotify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Notifier-Thread");

        waiter.start();
        notifier.start();
    }
}

