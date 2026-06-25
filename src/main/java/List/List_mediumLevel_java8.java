package List;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 1. string.chars() मेथड 'Character' नहीं, बल्कि 'IntStream' (primitive int) रिटर्न करता है।
//    जावा बैकएंड में अक्षरों को स्टोर करने के लिए IntStream (ASCII/Unicode values) का इस्तेमाल करता है।

// 2. mapToObj(c -> (char)c) उस primitive int को वापस primitive char में टाइपकास्ट करता है,
//    और mapToObj उसे 'Character' Object में कन्वर्ट (Auto-box) कर देता है। [Stream<Character>]

// 3. char -> Java isko Instream mai store karta hai , kyukiii [CharStream] aaisa kuch java mai nahi hai
//4 filter -> method always return stream (but uska res true and false chahiye )
//5 allMatch , anyMatch , noneMatch - > always return boolean

//6  s.chars() -> Intstream  boxed() -> intstream se Stream<Integer>
//7. list.stream() -> convert to Stream<Integer>

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
        boolean res = list.stream().anyMatch(s -> s.chars().mapToObj(c -> (char)c).anyMatch(Character::isDigit));
        System.out.println(res);
        System.out.println(checkDigitContains);

        //or

        boolean hasDigit = list.stream()
                .anyMatch(s -> s.chars().anyMatch(Character::isDigit));
        System.out.println("Way 2 -> " + hasDigit);
        System.out.println("------------------------------------------");

        //10.ANAGARAM
        String s1 = "abc";
        String  s2 = "bca";

        boolean isAnagram = s1.length() == s2.length() && s1.chars().boxed().sorted().collect(Collectors.toList()).equals(s2.chars().boxed().sorted().collect(Collectors.toList()));
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

        boolean isAnagramcheck = s1.length() == s2.length() &&
                Arrays.equals(s1.chars().sorted().toArray(),
                        s2.chars().sorted().toArray());


      //11 .find the product of all number
        List<Integer>ll = Arrays.asList(1,2,3,4);
        int ans = ll.stream().reduce(1,(a,b)-> a*b);
        System.out.println("prodcut is -> " +ans);

        //12 . check give me prime number
        List<Integer> prime = ll.stream().filter(no -> no > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(no)).noneMatch(num -> no % num == 0)).toList();
        System.out.println("prime number -> " + prime);

        //13 Merge two integer lists and sort them in reverse order without duplicates
        List<Integer> l1 = Arrays.asList(1, 3, 5);
        List<Integer> l2 = Arrays.asList(3, 4, 6);
        List<Integer> mergedSorted = Stream.concat(l1.stream(), l2.stream()).distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Merged Reverse Sorted: " + mergedSorted);

        //14 .Find the absolute differences between adjacent elements in a list
        List<Integer> diffList = Arrays.asList(10, 25, 33, 40);
        List<Integer>diffs = IntStream.range(0,diffList.size()-1).  // here it is in Intstream
                            map(i -> Math.abs(diffList.get(i) - diffList.get(i+1))).boxed().toList();
        System.out.println("Adjacent Differences: " + diffs);

        //15    Find the total number of characters across all strings in a list
        List<String> itemsList = Arrays.asList("Java", "C", "Python");
        int totalChars = itemsList.stream().mapToInt(String::length).sum();
        System.out.println("Total characters count: " + totalChars);

        //or
        String s= itemsList.stream().collect(Collectors.joining(""));
        System.out.println(s);
        System.out.println(s.length());

        //16 Find the string with the maximum number of unique characters
        List<String> uniqCheck = Arrays.asList("apple", "dinosaur", "java");
        String maxUnique = uniqCheck.stream().max(Comparator.comparingLong(p -> p.chars().distinct().count())).orElse("");
        System.out.println("Max Unique Chars String: " + maxUnique);


        //17  Convert a list of strings into a single comma-separated string enclosed in brackets [...]
        List<String> tags = Arrays.asList("Java", "Spring", "Docker");
        String formattedResult = tags.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Formatted String: " + formattedResult);









    }
}
