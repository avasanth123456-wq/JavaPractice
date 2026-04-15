package Stream;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee{
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id , String name, String dept, double salary){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;

    }


    public String toString(){
        return id +""+name+""+" "+ dept+""+ salary;
    }
}

public class StreamMapExample {

    static void main() {

        List<Employee> list = Arrays.asList(
                new Employee(1,"Saurabh","Sr.Software",1000000),
                new Employee(2,"Nag","Mangar",50000),
                new Employee(3,"Parvez","Trainee",30000),
                new Employee(4,"vasanth","Trainee",40000),
                new Employee(5,"Manjo","FullStuckDeveloper",70000),
                new Employee(6,"Vamshi","Software Engineering",60000),
                new Employee(7,"Ajay","Backend Developer",80000),
                new Employee(8,"ShivaKirshna","Developer",90000)

        );
        //Filter + Map
        System.out.println("1. IT Employees Names:");
            list.stream()
                    .filter(e->e.dept.equals("Mangar"))
                    .map(e->e.name)
                    .forEach(System.out::println);

            // Sort by Salary
        System.out.println("\n2 .Sorted by Salary");
        list.stream()
                .sorted(Comparator.comparingDouble(e-> e.salary))
                .forEach(System.out::println);
         //Grouping by Department
        System.out.println("\n3 .Group by Department::.");
        Map<String,List<Employee>> groupByDept =
                list.stream()
                        .collect(Collectors.groupingBy(e->e.dept));

        groupByDept.forEach((k,v)->{
            System.out.println(k+""+v);
        });
       // Count employees per department
        System.out.println("\n4 .Count per Department:");
        Map<String,Long> countDept =
                list.stream()
                        .collect(Collectors.groupingBy(e->e.dept,
                                Collectors.counting()));

        System.out.println(countDept);

        // Average salary per department
        System.out.println("\n5 . Average salary per department:");
        Map<String,Double> avgSalary=

                list.stream()
                        .collect(Collectors.groupingBy(e->e.dept,
                                Collectors.averagingDouble(e->e.salary)));

        System.out.println(avgSalary);

        //Convert List → Map
        System.out.println("\n6.List to Map (id -> name):");
        Map<Integer,String> idNameMap=
             list.stream()
                     .collect(Collectors.toMap(
                             e->e.id,
                             e->e.name
                     ));
        System.out.println(idNameMap);

         //Find max salary employee
         System.out.println("\n7.Max Salary Employee:");
         Optional<Employee> maxEmp =
                 list.stream()
                         .max(Comparator.comparingDouble(e-> e.salary));

         maxEmp.ifPresent(System.out::println);

       // Partition (salary > 50000)
        System.out.println("\n8. Partition salary > 50000:");
        Map<Boolean,List<Employee>> partition =
                list.stream()
                        .collect(Collectors.partitioningBy(e->e.salary>50000));

        System.out.println(partition);
        //Reduce (Total Salary)
        System.out.println("\n9.Total Salary");
        double totalSalary =
                list.stream()
                        .map(e->e.salary)
                        .reduce(0.0,Double::sum);
        System.out.println(totalSalary);

        // Distinct Departments
        System.out.println("\n10.Distinct Departments");
        list.stream()
                .map(e->e.dept)
                .distinct()
                .forEach(System.out::println);
    }

}
