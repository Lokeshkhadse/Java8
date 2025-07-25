package Object_java8;

import java.util.Arrays;
import java.util.List;

class Employee {
    int id;
    String name;
    String department;
    double salary;
    int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    public String toString() {
        return id + " - " + name + " - " + department + " - " + salary + " - " + age;
    }

    // 🔸 Make this list public static so it's accessible from other classes
    public static final List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "HR", 40000, 25),
            new Employee(2, "Bob", "IT", 60000, 28),
            new Employee(3, "Charlie", "Finance", 55000, 30),
            new Employee(4, "David", "IT", 70000, 35),
            new Employee(5, "Eva", "HR", 45000, 26),
            new Employee(6, "Frank", "IT", 50000, 24)
    );
}
