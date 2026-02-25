package UserInput;


import javax.naming.Name;
import java.util.Scanner;

public class UserInputDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name:");
        String name = sc.nextLine();

        System.out.print("Enter your Age");
           int age = sc.nextInt();
           System.out.print("Enter your marker");
           double marks = sc.nextDouble();
           System.out.println("Name:" + name);
          System.out.println("age:"+ age);
        System.out.println("Marks:" + marks);


    }
}
