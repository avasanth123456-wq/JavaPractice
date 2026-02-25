import Abstract.MyClass;
import classes.Audi;
import classes.Car;

import java.util.*;

public class Main {

    public static int getDouble(int x) {
        return x * 2;
    }

    public static String getFullName(String firstName ,String lastName) {
        return firstName + " " + lastName;

//        firstName.length()
    }
       public static int getNameLength(String name  ){
       return name.length ();

       }
    public static void main(String[] args) {

        List<String> list =  new ArrayList<>();

        System.out.println( getDouble(400));
         System.out.println(getFullName("ajmira","vasanth"));
         System.out.println(getNameLength("vamika "));

        Car c = new Car(1000);
        Audi r3 = new Audi("R3",1000);


        MyClass myClass = new MyClass();
        myClass.method1();
        myClass.method2();

    }
}






