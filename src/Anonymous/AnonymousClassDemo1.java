package Anonymous;

  class Animal{
      void sound() {
          System.out.println("Animal make a sound");
      }
  }
  public  class AnonymousClassDemo1{
       public static void main(String[] args){
           Animal dog = new Animal(){
           void sound() {
               System.out.println("Dogs braks");
           }
       };

       dog.sound();
  }

  }
