package Interface;

interface Vehicle{
    void start();
    void stop();

}
   class car implements Vehicle{
       @Override
       public void start() {
           System.out.println(" Car starts with key");
       }

       @Override
       public void stop() {
           System.out.println("Car stops with brake");
       }
   }
    class Bike implements Vehicle{
        @Override
        public void start() {
            System.out.println("Bike starts with self-start");

        }

        @Override
        public void stop() {
            System.out.println("Bike stop with disc brake ");
        }
    }


    public class InterFaceDemo{
    public static void main(String[] args ){

        Vehicle v1 = new car();
        v1.start();
        v1.stop();

        Vehicle v2 = new Bike();
        v2.start();
        v2.stop();
    }

    }