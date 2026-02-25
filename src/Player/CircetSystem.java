package Player;

import jdk.dynalink.beans.StaticClass;

import java.lang.reflect.Field;

class  Player{
     private String Fullname;
     private  String Role;
     private  int Runs;

     Player(String Fullname ,String Role, int Runs) {
         this.Fullname = Fullname;
         this.Role = Role;
         this.Runs = Runs;

     }

     public String getFullname() {return Fullname;}
     public String getRole() {return Role;}
     public int getRuns() {return Runs;}
     public void setRuns(int Runs) { this.Runs=Runs;}

     public void showPlayer(){
         System.out.println("Player: " + Fullname+ ", Role: " + Role + ", Runs: " + Runs);

     }
 }
   class Batsman extends  Player{
     private int centuries;
     Batsman( String Fullname,int Runs, int centuries) {
         super(Fullname,"Batsman",Runs);
         this.centuries =  centuries;

     }

     public void showPlayer(){
         super.showPlayer();
         System.out.println("centuries:" + centuries);
     }
   }

    class Bowler extends Player{
     private int wickets;
        Bowler(String Fullname, int Runs,int wickets) {

         super(Fullname,"Bowler", wickets);
         this.wickets= wickets;
     }

      public void showPlayer(){

         super.showPlayer();

         System.out.println("wickets:"+ wickets);
      }
    }
     abstract class Match{

     abstract void startMatch();
         void showFormat(){
             System.out.println(" This is a cricket match!");
         }
     }

     class ODI extends Match{
         @Override
         void startMatch() {
             System.out.println(" ODI Match Started .... 50 over game");
         }
     }

class T20 extends Match{
    @Override
    void startMatch() {
        System.out.println(" T20 Match Started .... 20 over game");
    }
}
class Test extends Match{
    @Override
    void startMatch() {
        System.out.println(" Test Match Started .... 5 days game");
    }
}
 interface  Umpire{
     void makeDecisoin(String decision);
 }

 class FieldUmpire implements  Umpire{
     @Override
     public void makeDecisoin(String decision) {
         System.out.println("Field Umpire Decision: " + decision);
     }
 }
  class  ThirdUmpire implements Umpire{
      @Override
      public void makeDecisoin(String decision) {
          System.out.println("Third Umpire Decision:" + decision);
      }
  }

   class Stadium{
     String name = " Uppal Stadium";

   }

    class UppalStadium extends Stadium{
      String name =" UppalStadium ,Hyderbad";

      void showNames(){
          System.out.println("Using this:" + this.name);
          System.out.println("Using super:" + super.name);
      }
    }
     public class CircetSystem{

     public static  void main(String[] args){
         Batsman virat = new Batsman("Virat Kohli",14181,51 );
         Batsman Rohit = new Batsman("Rohit Sharam",11168,32);
         Bowler Bumarh = new Bowler( "Jasprit Bumrah",341,219);
         Bowler Mohammed= new Bowler("Mohammed Siraj",250,108);

             virat.showPlayer();
             Rohit.showPlayer();
            System.out.println("-------------------");
            Bumarh.showPlayer();
            Mohammed.showPlayer();
            System.out.println("=====================");

            Match  T20 = new T20();
            Match ODI = new ODI();
            Match Test = new Test();


            T20.showFormat();
            T20.startMatch();
             ODI.startMatch();
            Test.startMatch();
            System.out.println("===========================");

            Umpire field = new FieldUmpire();
            Umpire Third = new ThirdUmpire();

            field.makeDecisoin("OUT !");
            Third.makeDecisoin("NOT OUT!");

         System.out.println("===============================");

         UppalStadium stadium= new UppalStadium();
         stadium.showNames();
      }

     }