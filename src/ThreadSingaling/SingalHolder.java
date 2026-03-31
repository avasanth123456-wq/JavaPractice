package ThreadSingaling;

public class SingalHolder {

    private boolean signalRaised = false;
    private boolean isThreadWaiting = false;

    public void doNotify() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "calling notify()");
            if (!this.isThreadWaiting) {
                this.signalRaised = true;
            }
            this.notify();
            System.out.println(Thread.currentThread().getName() + "exited notify()");
        }
    }

    public void doWait() throws InterruptedException {
        synchronized (this) {
            if (this.signalRaised) {
                System.out.println(Thread.currentThread().getName() + "signal was arleady raised-decrementing signals and return");
                    this.signalRaised = false;
                    return;
                }

                System.out.println(Thread.currentThread().getName() + "calling nwait()");
               this.isThreadWaiting = true;
               this.wait();
               this.isThreadWaiting=false;
            System.out.println(Thread.currentThread().getName() + "exited wait()");
        }
            }
        }

