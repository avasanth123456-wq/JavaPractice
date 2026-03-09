package Synchronized;

public class SyncCounter {
    private long count =0;

    public synchronized  void incCount(){
        this.count++;
    }
    public synchronized long getcount(){
        return this.count;
    }

  public   static void main(String[] args) {
        SyncCounter counter = new SyncCounter();

        Thread thread1 = new Thread(()->{
            for(int i=0;i<1_000_00;i++){
                counter.incCount();
            }
            System.out.println(counter.getcount());
        });

      Thread thread2 = new Thread(()->{
          for(int i=0;i<1_000_00;i++){
              counter.incCount();
          }
          System.out.println(counter.getcount());
      });

      thread1.start();
      thread2.start();
    }
}
