package String;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Medium_Hard_String {
    public static void main(String[] args) {

        //1.Find duplicate characters in a string
        String input = "programming";

        Set<Character>seen = new HashSet<>();
        Set<Character> duplicate = input.chars().mapToObj(c -> (char)c).filter(c -> !seen.add(c)).collect(Collectors.toSet());
        System.out.println(("duplicate character is -> " + duplicate));
        System.out.println("---------------------------------------------");

      //2.Check if two strings are anagrams
        String s1 = "listen";
        String s2 = "silent";

        boolean isAnagram = s1.length() == s2.length() &&
                s1.chars().sorted().boxed().collect(Collectors.toList())
                        .equals(s2.chars().sorted().boxed().collect(Collectors.toList()));

        System.out.println(isAnagram);
        System.out.println("---------------------------------------------");


        //3.Get all unique characters sorted alphabetically
        String uniqueCharString = input.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println("uniqueCharString -> " +uniqueCharString);
        System.out.println("---------------------------------------------");

        //4. Count total number of words in a sentence
        String sentence = "Java 8 stream API is powerful";
       long cnt = Arrays.stream(sentence.split("\\s+")).count();
        System.out.println("count is -> " + cnt);
        System.out.println("---------------------------------------------");

        //5.Count vowels and consonants separately
        String abc = "Java8 Stream";
        Map<String,Long> ans = abc.toLowerCase()
                .chars()
                .filter(c -> Character.isLetter(c))
                .mapToObj(c -> "aeiou".indexOf(c) != -1 ? "vowels" : "consonants")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("count of vowels & constant -> " + ans);
        System.out.println("---------------------------------------------");









    }
}
