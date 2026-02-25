package Map;

import java.util.ArrayList;
import java.util.List;

class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.id - s.id; // sort by id
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
public class ComparableDemo {

    public  static void  main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"Rohel"));
        list.add(new Student(2,"Riju"));
        list.add(new Student(3,"Vamika"));
        list.add(new Student(4,"Vasanth"));
        List<Integer> numbers = new ArrayList<>();
        //numbers.add(2);
       // numbers.add(1);
       // numbers.add(99);
      //  numbers.sort(null);
        list.sort(null);
       System.out.println(list);
       // System.out.println(numbers);
    }
}
