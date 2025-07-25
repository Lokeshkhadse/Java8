package Supplier;
import java.util.*;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {

        //A Supplier<T> is a functional interface in Java 8 that supplies a value (of type `T) without taking any input.

        Supplier<String> messageSupplier = () -> "Hello from Supplier!";
        System.out.println(messageSupplier.get()); // Output: Hello from Supplier!

        Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 100);
        System.out.println("Random Number: " + randomSupplier.get());


    }
}
