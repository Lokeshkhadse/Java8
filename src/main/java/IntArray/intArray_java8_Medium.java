package IntArray;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class intArray_java8_Medium {
    public static void main(String[] args) {
        //1. Count frequency of each element
        int[] arr = {1, 2, 2, 3, 3, 3};
        Map<Integer,Long> counTFreq = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i -> i,Collectors.counting()));
        System.out.println(" Count frequency of each element " + counTFreq);
        System.out.println("--------------------");

        //2. Remove duplicates and get count
       long cnt = Arrays.stream(arr).distinct().count();
        System.out.println(" after removing dupli count is -> " + cnt);
        System.out.println("--------------------");

        //3.Group numbers as even or odd
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd")).forEach((key ,val) -> System.out.println(key + " " + val));
        Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0)).forEach((key ,val) -> System.out.println(key + " " + val));
        System.out.println("--------------------");

        //4.occurance of element  and

        int mostFreq = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())  //or .max(Map.Entry.comparingByValue()) // or filter(e -> e.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
        System.out.println("Most Frequent: " + mostFreq);
        System.out.println("--------------------");

        //5.Sum of squares of even numbers
        int sum = Arrays.stream(arr).filter(no -> no % 2 == 0).map(no -> no * 2).sum();
        System.out.println("Sum of squares of even numbers -> " + sum);
        System.out.println("--------------------");


        //6. Find top 3 highest numbers
        Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::print);
        System.out.println("--------------------");

        //7.Find number with minimum frequency
        int minimumFreq = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().
                          min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);

        //or


//     int minFreq = Arrays.stream(nums)
//             .boxed()
//             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//             .entrySet().stream()
//             .sorted(Map.Entry.comparingByValue())
//             .map(Map.Entry::getKey)
//             .findFirst()
//             .orElse(-1);
        System.out.println("number with minimum frequency -> " + minimumFreq);
        System.out.println("--------------------");


        //8.Check if all elements are unique
        boolean isUnique = Arrays.stream(arr).distinct().count() == arr.length;
        System.out.println("all elements are unique -> " + isUnique);
        System.out.println("--------------------");

        //9.Check if array is palindrome
        int[] arr1 = {1, 2, 3, 2, 1};

        boolean isPalindrome = IntStream.range(0, arr1.length / 2)
                .allMatch(i -> arr1[i] == arr1[arr1.length - i - 1]);

        System.out.println("If array is palindrome -> " + isPalindrome);
        System.out.println("--------------------");

        //10.Count primes in array
        long primeCount = Arrays.stream(arr).boxed().filter(n -> n > 1 && IntStream.rangeClosed(2,(int) Math.sqrt(n)).allMatch(i -> n % i != 0)).count();
        System.out.println("Count primes in array -> " + primeCount);
        System.out.println("--------------------");

        //11. Find product of all elements
        int prod = Arrays.stream(arr).reduce(1,(a,b) -> a * b);
        System.out.println("product of each element -> " + prod);
        System.out.println("--------------------");

        //12.Find all duplicates
        Set<Integer> uni = new HashSet<>();
        Set<Integer>dupli = Arrays.stream(arr1).boxed().filter(no -> !uni.add(no)).collect(Collectors.toSet());
        System.out.println("duplicate element is -> " + dupli);

        //13.Map index to value (Map<Integer, Integer>)
        int[] mm = {1,2,3,4,5};
        Map<Integer, Integer> indexMap = IntStream.range(0, mm.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> mm[i]));
        System.out.println(indexMap);
        System.out.println("--------------------");


        //14.Print all combinations of adjacent pairs
        IntStream.range(0, mm.length - 1)
                .mapToObj(i -> mm[i] + "," + mm[i + 1])
                .forEach(System.out::println);
        System.out.println("--------------------");

        //15.Count how many elements are repeated
        long repeated = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(c -> c.getValue() > 1).count();
        System.out.println("Repeated Count: " + repeated);
        System.out.println("--------------------");

        //16.Convert to binary string list
        List<String> binaries = Arrays.stream(arr)
                .mapToObj(Integer::toBinaryString)
                .collect(Collectors.toList());
        System.out.println("binary string list -> " +binaries);
        System.out.println("--------------------");

        //17. Sort by number of digits
        int[] digit = {111,22,3,44444};
        List<Integer> sortedByDigits = Arrays.stream(digit)
                .boxed()
                .sorted(Comparator.comparingInt(n -> String.valueOf(n).length()))
                .collect(Collectors.toList());
        System.out.println("Sorted by Digit Length: " + sortedByDigits);











    }
}
