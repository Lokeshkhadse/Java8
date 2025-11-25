package DesignPattern.Creational;

// Ensure one instance of a class and provide a global access point.

public class SingletonDemo {
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);  // true → same object reused
    }
}
class Singleton{
    private static Singleton instance;

    private Singleton(){
        System.out.println("Singleton object created");
    }

    public static synchronized  Singleton getInstance(){
        if(instance == null){
           instance = new Singleton();
        }
        return instance;
    }

}

