package List;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class List_mediumLevel_java8 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Ankita", "Raj", "Sundaram", "Ramesh","Raj");

        //1. Get top 3 longest names from a list
        names.stream().sorted(Comparator.comparingInt(String::length).reversed()).limit(3). forEach(System.out::println);
        System.out.println("------------------------------------------");

        //2.Count frequency of each name in the list
        Map<String ,Long> cntFreq = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(cntFreq);
        System.out.println("------------------------------------------");

        //3.Get second highest length name
        String SecondHighestName = names.stream().sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().orElse("not found");
        System.out.println("SecondHighestName is -> " + SecondHighestName);
        System.out.println("------------------------------------------");

        //4.Create list of only first characters
        List<Character> only1stChar = names.stream().map(s -> s.charAt(0)).toList();
        System.out.println(only1stChar);
        System.out.println("------------------------------------------");

        //5.Join all names with | separator
        String finalName = names.stream().collect(Collectors.joining("|"));
        System.out.println("Final name is -> " + finalName);
        System.out.println("------------------------------------------");

       // 6. Find all names that occur more than once
        Map<String ,Long> countMoreOccurance = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<String> dupli = countMoreOccurance.entrySet().stream().filter( s -> s.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println("multiple names occurance -> " + dupli);
        System.out.println("------------------------------------------");

        //7. Each Character-Occurrence letter
        String finalString = names.stream().collect(Collectors.joining(""));
        System.out.println(finalString);
        Map<Character,Long> characterFreq  = finalString.chars().mapToObj( c -> (char) c).collect(Collectors.groupingBy(s-> s ,Collectors.counting()));
        System.out.println(characterFreq);
        System.out.println("------------------------------------------");

        //8.Find the average length of all names
        double avgLength = names.stream().map(String::length).mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("avg length is ->  " + avgLength);
        System.out.println("------------------------------------------");


        //9. Check if any name contains a digit
        List<String> list = Arrays.asList("Rahul", "Ankita1", "Ajay");
        boolean checkDigitContains = list.stream().anyMatch(s -> s.matches(".*\\d.*"));
        System.out.println(checkDigitContains);

        //or

        boolean hasDigit = list.stream()
                .anyMatch(s -> s.chars().anyMatch(Character::isDigit));
        System.out.println("Way 2 -> " + hasDigit);
        System.out.println("------------------------------------------");

        //10.ANAGARAM
        String s1 = "abc";
        String  s2 = "bca";

        boolean isAnagram = s1.length() == s2.length() && s1.chars().sorted().boxed().collect(Collectors.toList()).equals(s2.chars().sorted().boxed().collect(Collectors.toList()));
        System.out.println(isAnagram);
        System.out.println("------------------------------------------");

      //or using lowercase check-Anagram
        String s3 = "abc";
        String  s4 = "Bca";

        boolean isAnagram1 = s3.length() == s4.length() &&
                s3.toLowerCase().chars().sorted().boxed().toList()
                        .equals(s4.toLowerCase().chars().sorted().boxed().collect(Collectors.toList()));
        System.out.println(isAnagram1);
        System.out.println("------------------------------------------");






    }
}
