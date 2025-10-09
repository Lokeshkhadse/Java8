package List;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class List_Easy_Java8 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ajay","lokesh", "rahul", "Ajay");

        //1. Convert list of strings to uppercase
        List<String> toupper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
         System.out.print(" " + toupper);
        System.out.println("---------------------------------- > ");

         // 2. first letter make uppercase
        names.stream().map(s -> s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase()).forEach(System.out::println);
        System.out.println("---------------------------------- > ");

        //3. Filter names that start with "A"
        names.stream().filter(s -> s.startsWith("A") || s.startsWith("a")).forEach(System.out::println);
        System.out.println("---------------------------------- > ");

        //4. Sort names alphabetically
        names.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------------------- > ");

        //5. Count how many names are longer than 4 characters
        long count = names.stream().filter(s -> s.length() > 4).count();
        System.out.println("count is  -> " + count);
        System.out.println("---------------------------------- > ");

        //6.Convert list of names to a comma-separated string
        String result = names.stream().collect(Collectors.joining(","));
        //or         String result = String.join(",", names);
        System.out.println("String result is -> " + result);
        System.out.println("---------------------------------- > ");

        //7.Remove duplicate names from list
        names.stream().map(String::toLowerCase).distinct().forEach(System.out::println);
        System.out.println("---------------------------------- > ");


        //8. Get the first name in the list
        //  Optional<String> name1st = names.stream().findFirst();
        // System.out.println("first name in the list ->" + name1st.get());
         String name1st = names.stream().findFirst().orElse("No Name");
        System.out.println("first name in the list ->" + name1st);
        System.out.println("---------------------------------- > ");

        //9.Group list of strings by their length
        Map<Integer,List<String>> groupLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupLength);
        System.out.println("---------------------------------- > ");

        //10. Find duplicate elements in a list
        Set<String> uni = new HashSet<>();
        Set<String> dupli = names.stream().map(name -> name.toLowerCase()).filter(name -> !uni.add(name)).collect(Collectors.toSet());
        System.out.println(dupli);
        System.out.println("---------------------------------- > ");

        //11. Convert list of strings to map (string -> length)
        Map<String,Integer> tomap = names.stream().collect(Collectors.toMap(name -> name ,String::length));
        System.out.println(tomap);
        System.out.println("---------------------------------- > ");

        //12.Find the longest string in the list
         String maxLengthString = names.stream().max(Comparator.comparingInt(String::length)).orElse("not found");
        System.out.println("maxLengthString is -> " + maxLengthString);
        //or String maxName = names.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().orElse("not found");
        System.out.println("---------------------------------- > ");

        //13.Partition names by even/odd length
         names.stream().collect(Collectors.partitioningBy( s -> s.length() % 2 == 0)).forEach((key , value) -> {
            System.out.println( key + "-> " + value );
        });
        System.out.println("---------------------------------- > ");


        //14.Custom sort strings by length and then alphabetically
        names.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
        System.out.println("---------------------------------- > ");

        //15. Find common elements in two lists
        List<String> list1 = Arrays.asList("Java", "Python", "C");
        List<String> list2 = Arrays.asList("Python", "C", "Go");

        List<String> common = list1.stream().filter(s -> list2.contains(s)).collect(Collectors.toList());
        System.out.println(" common element is -> " + common);
        System.out.println("---------------------------------- > ");

        //16. Count how many names contain the letter 'a' (case-insensitive)
        long cnt = names.stream().filter( s -> s.contains("a")).count();
        System.out.println(" cnt is -> " + cnt);
        System.out.println("---------------------------------- > ");

      //17.Find total length of all names (reduce)
//        int totalLength = names.stream().map(String::length).mapToInt(Integer::intValue).sum();
        int totalLength = names.stream().map(String::length).mapToInt(Integer::intValue).reduce(0,(a,b) -> {
            return a +b;
        });
        System.out.println("total length of sum is  -> " + totalLength);
        System.out.println("---------------------------------- > ");

        //18. Convert List<String> to Map<Character, List<String>> grouped by first letter
        Map<Character,List<String>> groupBy1stLetter = names.stream().map(String::toLowerCase).collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(groupBy1stLetter);
        System.out.println("---------------------------------- > ");

      //19. Remove null or empty strings from a list
        List<String> list = Arrays.asList("Ajay", "", null, "Rahul");

        list.stream().filter( s ->  s != "").filter(s -> s != null).forEach(System.out::println);
        //or list.stream().filter(Objects::nonNull).filter(s -> !s.isEmpty()).forEach(System.out::println);
        System.out.println("---------------------------------- > ");

        //20. Check if all names are non-null and length > 2
        boolean valid = list.stream().anyMatch( s -> s != null && s.length() > 2);
        System.out.println(valid);
        System.out.println("---------------------------------- > ");

        //21.find second highest number
        List<Integer> number = Arrays.asList(1,2,3,4,5,6);
        int secondHighestNo = number.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(Integer.MIN_VALUE);
        System.out.println("second Highest No is -> " + secondHighestNo);

        //22. find second Lowest number
        int secondLowestNumber = number.stream().sorted().skip(1).findFirst().orElse(-1);
        System.out.println("secondLowestNumber is -> " + secondLowestNumber);





        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);

        // Sum
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // Average
        double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + avg);

        // Min
        int min = numbers.stream().mapToInt(Integer::intValue).min().orElse(Integer.MIN_VALUE);
        System.out.println("Min: " + min);

        // Max
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE);
        System.out.println("Max: " + max);

        // Count
        long count1 = numbers.stream().mapToInt(Integer::intValue).count();
        System.out.println("Count: " + count1);


        //palindrome
        List<String> list3 = Arrays.asList("madam", "apple", "level", "cat");
        List<String> result3 = list3.stream()
                .filter(x -> x.equals(new StringBuilder(x).reverse().toString()))
                .collect(Collectors.toList());

        System.out.println(result3);















    }
}
