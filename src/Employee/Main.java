package Employee;
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    void displayInfo() {
        System.out.println("[Manager Info]");
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("John", 50000);
        Employee m = new Manager("Alice", 80000, "IT");

        System.out.println("=== Employee Object ===");
        e.displayInfo();

        System.out.println("\n=== Manager Object ===");
        m.displayInfo();
    }
}

