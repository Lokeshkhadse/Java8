package Optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        System.out.println("===== 1. Creation =====");
        Optional<String> nonNullOpt = Optional.of("Java");
        Optional<String> nullableOpt = Optional.ofNullable(null);
        Optional<String> emptyOpt = Optional.empty();

        System.out.println(nonNullOpt);   // Optional[Java]
        System.out.println(nullableOpt);  // Optional.empty
        System.out.println(emptyOpt);     // Optional.empty

        System.out.println("\n===== 2. Presence Check =====");
        System.out.println(nonNullOpt.isPresent());  // true
        System.out.println(nullableOpt.isEmpty());   // true
        System.out.println(nonNullOpt.isEmpty());    // false

        System.out.println("\n===== 3. Access Value =====");
        System.out.println(nonNullOpt.get());             // Java
        System.out.println(nullableOpt.orElse("Default"));      // Default
        System.out.println(nullableOpt.orElseGet(() -> "From Supplier")); // From Supplier

        // Throws NoSuchElementException if empty
        // System.out.println(nullableOpt.get());

        System.out.println("\n===== 4. orElseThrow =====");
        try {
            System.out.println(nullableOpt.orElseThrow()); // Throws Exception
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getClass().getSimpleName());
        }

        try {
            System.out.println(nullableOpt.orElseThrow(() -> new RuntimeException("Custom Exception"))); // Throws Custom
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("\n===== 5. map and flatMap =====");
        Optional<String> mapped = nonNullOpt.map(String::toUpperCase);
        System.out.println(mapped); // Optional[JAVA]

        Optional<Optional<String>> nested = nonNullOpt.map(s -> Optional.of(s + " Stream"));
        System.out.println(nested); // Optional[Optional[Java Stream]]

        Optional<String> flatMapped = nonNullOpt.flatMap(s -> Optional.of(s + " Stream"));
        System.out.println(flatMapped); // Optional[Java Stream]

        System.out.println("\n===== 6. filter =====");
        System.out.println(nonNullOpt.filter(s -> s.startsWith("J"))); // Optional[Java]
        System.out.println(nonNullOpt.filter(s -> s.contains("x")));   // Optional.empty

        System.out.println("\n===== 7. ifPresent and ifPresentOrElse =====");
        nonNullOpt.ifPresent(val -> System.out.println("Value exists: " + val));

        nullableOpt.ifPresentOrElse(
                val -> System.out.println("Value: " + val),
                () -> System.out.println("No value present")
        );
    }
}
