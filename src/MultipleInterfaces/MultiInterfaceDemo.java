package MultipleInterfaces;

 interface camera{
     void takePhoto();
 }

  interface MusicPlayer{
     void palyMusic();
  }
     class SmartPhone implements camera ,MusicPlayer{
         @Override
         public void takePhoto() {
             System.out.println(" Taking photo with 100MP camera");
         }

         @Override
         public void palyMusic() {
             System.out.println("Playing music in Dolby Atmos");
         }
     }

     public class MultiInterfaceDemo{

     public static void main(String[] args){

         SmartPhone sp = new SmartPhone();
         sp.takePhoto();
         sp.palyMusic();
     }
     }
