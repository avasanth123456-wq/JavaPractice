package OOP;

class Animal {
      void eat(){
          System.out.println(" Animal is eating....");
      }
   }
 class goat extends Animal {
     void baa(){
         System.out.println("Goat is baaa...");
     }
 }

 class Calculator{
     int add(int a, int b){
         return a+b;
     }
      int add(int a,int b,int c){
         return a + b+ c;
      }
 }
  class Shape{
     void draw(){
         System.out.println("Drawing is  auto ");
     }
  }
   abstract class Vehicle{
      abstract void start();
   }
     class car extends Vehicle{

         @Override
         void start() {
             System.out.println("Car starts with key");
         }
     }
      interface Playable{
        void play();
      }

      class Music implements Playable{
          @Override
          public void play() {
              System.out.println("Playing music");
          }
      }
       class Parent{
       String msg = "Hello from parents";
       }
  class Child extends Parent{
     String msg = "Hello from child";

     void  display(){
         System.out.println(this.msg);
         System.out.println(super.msg);
     }
  }

  public  class  OPPAllConcepts {

     public static void main(String[] args){

         //Persons p = new Person();
        // p.setName("vasanth");
        // System.out.println(" Name: " + p.getName());

         goat g = new goat();
         g.eat();
         g.baa();
         Calculator c = new Calculator();
         System.out.println("   " +c.add(10,20));
         System.out.println("   "+c.add(10,20,30));

         Shape s = new auto();

         s.draw();

         Vehicle v = new car();
         v.start();

         Playable m = new Music();
         m.play();
         Child child = new Child();
         child.display();

     }
}
