package Multithreading;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class MultiThreadCollectionStreamDemo {


    private static List<Employee> employees =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            employees.add(new Employee(1, "Vasanth", 50000));
            employees.add(new Employee(2, "Rahul", 70000));
        };


        Runnable task2 = () -> {
            employees.add(new Employee(3, "Anil", 45000));
            employees.add(new Employee(4, "Kiran", 80000));
        };


        Runnable task3 = () -> {
            employees.add(new Employee(5, "Ajay", 60000));
            employees.add(new Employee(6, "Suresh", 90000));
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All Employees:");
        employees.forEach(System.out::println);

        System.out.println("\nEmployees Salary > 60000");

        List<Employee> highSalaryEmployees =
                employees.stream()
                        .filter(emp -> emp.getSalary() > 60000)
                        .collect(Collectors.toList());

        highSalaryEmployees.forEach(System.out::println);

        System.out.println("\nEmployee Names:");

        List<String> names =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.toList());

        System.out.println(names);

        System.out.println("\nTotal Salary:");

        double totalSalary =
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum();

        System.out.println(totalSalary);

        System.out.println("\nHighest Salary:");

        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }
}