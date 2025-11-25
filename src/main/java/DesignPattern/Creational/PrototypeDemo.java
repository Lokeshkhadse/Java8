package DesignPattern.Creational;

//create new object  by cloning exisiting instance , shallow and deep copy used


interface Prototype extends Cloneable {
    Prototype clone();
}

class Employee implements Prototype {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Prototype clone() {
        return new Employee(this.name, this.age);
    }

    public String toString() { return name + " - " + age; }
}

public class PrototypeDemo {
    public static void main(String[] args) {

        Employee e1 = new Employee("Lokesh", 25);
        Employee e2 = (Employee) e1.clone();

        System.out.println(e1);
        System.out.println(e2);
    }
}
