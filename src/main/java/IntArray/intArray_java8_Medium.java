package IntArray;
import javax.print.attribute.IntegerSyntax;
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
        long primeCount = Arrays.stream(arr).filter(n -> n > 1 && IntStream.rangeClosed(2,(int) Math.sqrt(n)).allMatch(i -> n % i != 0)).count();
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

        //18 find k th largest element
      int k = 2;
      int ele = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(k-1).findFirst().orElse(-1);
     System.out.println("kth Largest element->" + ele);

     //19 intersection of 2 array
     int[] a = {1,2,4,5};
     int[] b = {2,3,5,8};

     int[] m = Arrays.stream(a).distinct().filter(anum -> Arrays.stream(b).anyMatch(bnum -> bnum == anum)).toArray();
     System.out.println("intersection of 2 element -> " + Arrays.toString(m));

     //20 Cumulative sum of array
     int[] numsForSum = {1, 2, 3, 4}; // आउटपुट होना चाहिए [1, 1+2, 1+2+3, 1+2+3+4] -> [1, 3, 6, 10]

     int[] cumulativesum = IntStream.range(0,numsForSum.length)
             .map(i -> Arrays.stream(numsForSum).limit(i+1).sum()).toArray();
     System.out.println("Cumulative sum of array " + Arrays.toString(cumulativesum));

     //21 rotate array by z step
     int[] rotate = {1,2,3,4,5};
     int z = 2;
     int n = rotate.length;

     int[] rotateArrAns = IntStream.concat(
                       Arrays.stream(rotate).skip(n-z),   //[4,5]
                       Arrays.stream(rotate).limit(n-z)  //[1,2,3]
                      ).toArray();
     System.out.println("Rotated array -> " + Arrays.toString(rotateArrAns));

     //22  Find missing numbers between 1 and 10
        int[] missingArr = {1, 3, 4, 7, 10};

        int[] miss = IntStream.rangeClosed(1, 10)
             .filter(number -> Arrays.stream(missingArr).noneMatch(no -> number == no))
             .toArray();
     System.out.println("miss -> " +Arrays.toString(miss));


     // or
       Set<Integer> ss = Arrays.stream(missingArr).boxed().collect(Collectors.toSet());
       int[] miss1 = IntStream.rangeClosed(1,10).
                  filter(aa -> !ss.contains(aa)).toArray();
     System.out.println("miss1 -> " + Arrays.toString(miss1));

     //23 check 2 arrays are anagram or not
     boolean result = Arrays.equals(
                    Arrays.stream(a).sorted().toArray(),
                    Arrays.stream(b).sorted().toArray()
     );
     System.out.println(" a & b arr is palindrome " + result);

     //24 . convert 2d array into single D
     int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};

     int[] flatmaparr = Arrays.stream(matrix)   // for 2D arr it convert first into Stream<int[]>
             .flatMapToInt(Arrays::stream)           // here internal arr convert into intstream
             .map(element -> element * 2)
             .toArray();

     System.out.println(Arrays.toString(flatmaparr));


     //25.first element repeating exactly 2 times
     int times = 2;

     int numo =Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
             .entrySet().stream().filter( i -> i.getValue() ==  times)
             .map(Map.Entry::getKey).findFirst().orElse(-1);
     System.out.println("first element repeating exactly 2 times is -> " +numo);


     //30 leaders of array
     int[] leadersArr = {16, 17, 4, 3, 5, 2};

     List<Integer> ls = IntStream.range(0,leadersArr.length)
             .filter(i -> IntStream.range(i+1,leadersArr.length).allMatch(j -> leadersArr[i] > leadersArr[j]))
             .boxed().map(i -> leadersArr[i]).toList();
     // or   .mapToObj(i -> leaderArr[i]).toList();
     System.out.println("leaders of array -> " + ls);



     // 31. Pattern match in array
     int[] mainArr = {1, 2, 3, 4, 5, 6};
     int[] pattern = {3, 4, 5};

     boolean patternFound = IntStream.rangeClosed(0, mainArr.length - pattern.length)
             .anyMatch(i -> IntStream.range(0, pattern.length).allMatch(j -> mainArr[i + j] == pattern[j]));
     System.out.println("Is pattern sub-array present? -> " + patternFound);

     //32, find peak element index
      // element is higher than it neighbour (left and right) adjacent
     int[] peakArr = {1, 3, 20, 4, 1, 0}; // 20 एक पीक है

     int peakIndex = IntStream.range(0,peakArr.length)
             .filter(i -> (i ==0 || peakArr[i] > peakArr[i-1]) && (i == peakArr.length-1 || peakArr[i] > peakArr[i+1]))
             .findFirst()
             .orElse(-1);
     System.out.println("Peak Element Index -> " + peakIndex);

     //33. find the maximum product or 2 number in arr
     List<Integer> ll = IntStream.range(0,peakArr.length)
             .boxed()
             .flatMap(i -> IntStream.range(i+1,peakArr.length).mapToObj(j -> peakArr[i] * peakArr[j]))
             .toList();
     System.out.println(ll);

     int max = ll.stream().mapToInt(Integer::intValue).max().orElse(-1);
     System.out.println("max product is -> " + max);

     //or

     int maxpro = IntStream.range(0, peakArr.length)
             .flatMap(i -> IntStream.range(i+1,peakArr.length).map(j -> peakArr[i]* peakArr[j])).max().orElse(-1);
     System.out.println("another approach max product is -> " + maxpro);

     //34 check arr is in ascending order
     int[] xyz = {1,2,5,4,6};
     boolean res = IntStream.range(0,xyz.length-1).
             allMatch(i ->  xyz[i] <= xyz[i+1]);
     System.out.println(" is arr in ascendign order -> " + res);











    }
}
