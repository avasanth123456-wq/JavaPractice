package Map;

import java.lang.ref.WeakReference;

import java.util.Map;
import java.util.WeakHashMap;
public class WeakHashMapDemo {
    public  static  void  main(String[] args){
        WeakHashMap<String,Image> imageCache = new WeakHashMap<>();
        loadCache(imageCache);
        System.out.println(imageCache);
        System.gc();
        simulateApplicationRunning();
        System.out.println("Cache after running( some entries may be cleared): " + imageCache);
    }

    private static void loadCache(Map<String, Image> imageCache) {
        String K1 = new String("img1");
        String K2 = new String("img2");
        imageCache.put( K1,new Image("img1"));
        imageCache.put( K2,new Image("img2"));
    }

    private static  void  simulateApplicationRunning(){
        try{
            System.out.println("simulate Application Running ....");
             Thread.sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}


class Image {
    private String name;

    public  Image (String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}