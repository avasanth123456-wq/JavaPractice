package JavaMemoryModel;



public class SeparateObjects {

   static class MyObject {

        public synchronized void printNumbers() {

            for (int i = 1; i <= 5; i++) {

                System.out.println(Thread.currentThread().getName() + " : " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyRunnable implements Runnable {

        MyObject myObject;

        public MyRunnable(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            myObject.printNumbers();
        }
    }



        public static void main(String[] args) {

            MyObject myObject = new MyObject();

            Runnable runnable1 = new MyRunnable(myObject);
            Runnable runnable2 = new MyRunnable(myObject);

            Thread thread1 = new Thread(runnable1, "Thread 1");
            Thread thread2 = new Thread(runnable2, "Thread 2");

            thread1.start();
            thread2.start();
        }
    }


  /*  public static void main(String[] args) {
        MyObject myObject = new MyObject();
       // int myLocalVar =0;
       // String mylocalString ="Text";
        Runnable runnable1 = new MyRunnable(myObject);
        Runnable runnable2 = new MyRunnable(myObject);

        Thread thread1 =
                new Thread(runnable1,"Thread 1");

        Thread thread2 =
                new Thread(runnable2,"Thread2");

        thread1.start();
        thread2.start();
    }
}*/
