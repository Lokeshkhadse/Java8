package String;

import java.util.*;
import java.util.stream.Collectors;

public class String_java8 {
    public static void main(String[] args) {
        //1. Convert string to uppercase
        String s =  "hii hello";
        String upperCase = s.toUpperCase();
        System.out.println(upperCase);
        System.out.println("-----------------------");

        //2.Capitalize first character
        String firstLetterCap = s.substring(0,1).toUpperCase() + s.substring(1);
        System.out.println(firstLetterCap);
        System.out.println("-----------------------");

        //3.Count number of vowels in string
        long countVowels  = s.chars().mapToObj(c -> (char) c )
                .filter( ch -> "aeiouAEIOU".indexOf(ch) != -1)
                .count();
        System.out.println(countVowels);
        System.out.println("-----------------------");


        //4.Reverse a string using Java 8
        String reverseString  =  new StringBuilder(s).reverse().toString();
        System.out.println("reverse String is -> " + reverseString);
        System.out.println("-----------------------");

        //5.Remove duplicate characters from a string
        String str = "banana";

        String  withoutDupliChar = str.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println(withoutDupliChar);
        System.out.println("-----------------------");

        //6.Count frequency of each character

        Map<Character,Long> countOfEachChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c , Collectors.counting()));
        System.out.println("countOfEachChar -> " + countOfEachChar);
        System.out.println("-----------------------");


        //7.Check if string contains digit
        String abc = "hii9";
        boolean isDigitContain = abc.chars().mapToObj(c -> (char) c).anyMatch(Character::isDigit);
        System.out.println("String contain digit -> " + isDigitContain);
        System.out.println("-----------------------");


        //8.Get first non-repeating character
        String input = "aabbcdee";

        char ch = input.chars().mapToObj(c -> (char) c )
                .collect(Collectors.groupingBy(c -> c , LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElse('z');
        System.out.println("first non-repeating character -> " + ch);
        System.out.println("-----------------------");

     //9.Remove whitespaces from a string
        String xyz = " j a v a  8 ";
        String finalres = xyz.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(ch1 -> String.valueOf((char)ch1)).collect(Collectors.joining());
        System.out.println("after removing whitespace ->" + finalres);
        System.out.println("-----------------------");


        //10. Split comma-separated string into list
        String SplitComma = "java,spring,react";
        List<String>separatedComma = Arrays.asList(SplitComma.split(","));
        System.out.println(separatedComma);
        System.out.println("-----------------------");

        //11. Replace all vowels with *
        String replace = "java programming";
        String finalString = replace.chars()
                .mapToObj(c -> "aeiouAEIOU".indexOf(c) != -1 ? "*" : String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("repalce all vowels with * -> " + finalString);
        System.out.println("-----------------------");

        //12.Remove all digits from a string
        String digit = "abc123xyz456";
        String removeAllDigit = digit.chars()
                .filter(c -> !Character.isDigit(c))
                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println("after Remove all digits from a string -> " + removeAllDigit);
        System.out.println("-----------------------");











    }
}
