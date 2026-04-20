package Map;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Employee {
    int id;
    String dept;
    String name;
    double salary;

    public Employee(int id, String dept, String name, double salary) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "" +dept+""+name+""+salary;

    }
}

class EmployeeCollection implements Iterable<Employee>{

    private List<Employee> employees = new ArrayList<>();

    public void add(Employee e){
        employees.add(e);
    }
    @Override
    public Iterator<Employee> iterator(){
        return employees.iterator();
    }

    public Iterator<Employee> highSalaryIterator(double minSalary){
        return new Iterator<Employee>() {
            private Iterator<Employee> it = employees.iterator();
            private Employee nextEmployee = null;


            private void findNext(){
                while (it.hasNext()){
                    Employee e = it.next();
                    if (e.salary >= minSalary){
                        nextEmployee = e;
                        return;
                    }
                }
                nextEmployee = null;
            }
            @Override
            public boolean hasNext(){
                if(nextEmployee == null){
                    findNext();
                }
                return nextEmployee != null;
            }
            @Override
            public  Employee next(){
                if(!hasNext()) throw  new NoSuchElementException();
                Employee result = nextEmployee;
                nextEmployee = null;
                return  result;
            }
        };
    }

    public  Iterator<Employee> departmentIterator(String dept){
        return  new Iterator<Employee>() {
            private Iterator<Employee> it = employees.iterator();
            private Employee nextEmployee = null;

            private  void findNext(){
                while (it.hasNext()){
                    Employee e =  it.next();

                    if (e.dept.equalsIgnoreCase(dept)){
                        nextEmployee =e;
                        return;
                    }
                }
                nextEmployee= null;
            }
            @Override
            public boolean hasNext(){
                if(nextEmployee == null){
                    findNext();
                }
                return nextEmployee !=null;
            }
            @Override

            public Employee next(){
                if (!hasNext()) throw  new NoSuchElementException();
                Employee result = nextEmployee;
                nextEmployee = null;
                return  result;
            }
        };
    }
}

public class IterableBigExample {
    public static void  main(String[] args) {

        EmployeeCollection collection = new EmployeeCollection();

        collection.add(new Employee(1,"A","IT",50000));
        collection.add(new Employee(2,"B","HR",60000));
        collection.add(new Employee(3,"c","IT",70000));
        collection.add(new Employee(4,"D","Finance",80000));
        collection.add(new Employee(5,"E","IT",40000));


        System.out.println("All Employee");

        for(Employee e : collection){
            System.out.println(e);
        }
        System.out.println("Using Iterator");

        Iterator<Employee> it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("High Salary Employees (>= 60000)");
        Iterator<Employee> highSalary = collection.highSalaryIterator(60000);
        while (highSalary.hasNext()){
            System.out.println(highSalary.next());
        }
        System.out.println(" IT Department Employees ");
        Iterator<Employee> itDept = collection.departmentIterator("IT");
        while (itDept.hasNext()) {
            System.out.println(itDept.next());
        }

        System.out.println(" Fail-Safe Iteration");
        List<Employee> safeList = new ArrayList<>(collectionToList(collection));
        for (Employee e : safeList) {
            System.out.println(e);
        }
    }

    public static List<Employee> collectionToList(EmployeeCollection col) {
        List<Employee> list = new ArrayList<>();
        for (Employee e : col) {
            list.add(e);
        }
        return list;
    }
}
