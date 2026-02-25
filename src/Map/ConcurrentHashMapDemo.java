package Map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main (String[] arg){
        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();

        Thread t1 = new Thread(()->{
               for( int i=1; i<=5; i++){
                   map.put(i,"Value-" +i);
                   System.out.println("Thread-1 added :" +i);
               }

           });
        Thread t2 = new Thread(()->{
            for( int i=6; i<=10; i++){
                map.put(i,"Value-" +i);
                System.out.println("Thread-2 added :" +i);
            }

        });
       t1.start();
       t2.start();

       try {
           t1.join();
           t2.join();
       }catch(Exception e){
           e .printStackTrace();

        }

         System.out.println("/nFinal Map :" + map);


        }
    }

