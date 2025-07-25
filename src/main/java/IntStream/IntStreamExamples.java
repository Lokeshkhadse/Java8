package IntStream;
import java.util.*;
import java.util.stream.IntStream;

public class IntStreamExamples {
    public static void main(String[] args) {

        // Sample array
        int[] arr = {1, 2, 3, 4, 5};

        // 1. Print numbers from 1 to 5 using IntStream.range()
        IntStream.range(1,6).forEach(System.out::print);
        System.out.println();
        System.out.println("------------------------------");


        // 2. Print numbers from 1 to 5 using IntStream.rangeClosed()
        IntStream.rangeClosed(1,5).forEach(System.out::print);
        System.out.println();
        System.out.println("------------------------------");

        // 3. Sum of array elements
        int sum = IntStream.of(arr).sum();
        System.out.println("sum or arr is -> " + sum);
        System.out.println("------------------------------");

        //4.find max element from arr'
        int maxEle = IntStream.of(arr).max().orElse(-1);
        System.out.println("max number is -> " + maxEle);
        System.out.println("------------------------------");

        //5. Find min element from arr
        int minEle = IntStream.of(arr).min().orElse(-1);
        System.out.println("min number is -> " + minEle);
        System.out.println("------------------------------");

        //6.find avg or arr
        double avg = IntStream.of(arr).mapToDouble(i -> i).average().orElse(0.0);
        System.out.println("avg is -> " + avg);
        System.out.println("------------------------------");

        //7. total Element count in arr
        long count = IntStream.of(arr).count();
        System.out.println("total element count is -> "  + count);
        System.out.println("------------------------------");

        //8.Create IntStream from array and multiply by 2
        IntStream.of(arr).map(n -> n*2).forEach(System.out::print);
        System.out.println("------------------------------");

        //9. Convert IntStream to List<Integer>
        List<Integer> list = IntStream.of(arr).boxed().toList();
        System.out.println(list);
        System.out.println("--------------------------------");

        // 10. Filter even numbers
       IntStream.of(arr).filter( no -> no % 2 == 0).forEach(System.out::print);
        System.out.println("--------------------------------");

        // 11. Convert IntStream to int[]
        int[] arr1 = IntStream.of(arr).toArray();
        System.out.println(Arrays.toString(arr1));
        System.out.println("--------------------------------");

        // 12. Skip first 2 elements
        IntStream.of(arr).skip(2).forEach(System.out::print);
        System.out.println("--------------------------------");

        // 13. Limit to first 3 elements
        IntStream.of(arr).limit(3).forEach(System.out::print);
        System.out.println("------------------------------------");

        // 14. Find first element > 3
        int ele = IntStream.of(arr).filter( no -> no >3).findFirst().orElse(-1);
        System.out.println("1st element is  < 3 -> " + ele);
        System.out.println("------------------------------------");












    }
}
