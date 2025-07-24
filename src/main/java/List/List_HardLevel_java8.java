package List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class List_HardLevel_java8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date");

        //🔹 1. Find the first non-repeating element in a list
        Map<String,Long> ans = list.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        String name = ans.entrySet().stream().filter( s -> s.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("1st non repeating element is -> " + name);
        System.out.println("---------------------------------");

        //🔹 2. Custom reduce to concatenate with separator (without Collectors.joining)
        String joinner = list.stream().reduce((a, b) -> {
            return  a + " -" + b;
        }).orElse("empty");
        System.out.println("concatenate Joinner  -> "+ joinner);
        System.out.println("---------------------------------");

        //3.Find top N frequent elements from a list
        List<String> items = Arrays.asList("a", "b", "c", "a", "b", "a");

        List<String> top2 = items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed() ).limit(2).map(Map.Entry::getKey).toList();
        System.out.println("top 2 N freq Element -> " + top2);
        System.out.println("---------------------------------");


















    }
}
