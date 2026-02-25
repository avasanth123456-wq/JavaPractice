package Enum;

 enum Day{
     MONDAY,TUESDAY,WENDESDAY, THRUSDAY,FRIDAY,SATUREDAY,SUNDAY
 }
  public class EnumDemo1 {
     public static void main(String[] args){
    Day today = Day.SATUREDAY;
      System.out.println("Today is : " + today);

      switch (today){
          case MONDAY :
              System.out.println("start of the week!");
              break;
          case FRIDAY:
              System.out.println("Almost weekend!");
              break;
          case SUNDAY:
              System.out.println("Relxa, it's holiday");
              break;
          default:
              System.out.println("mid-week working day");
      }

     }
}