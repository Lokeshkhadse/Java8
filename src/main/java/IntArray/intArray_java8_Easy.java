package IntArray;
import java.util.*;
import java.util.stream.Collectors;


public class intArray_java8_Easy {
    public static void main(String[] args) {

        //1.Print all elements
        int[] nums = {1, 2, 3, 4,5,6};
         Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------------------");

        //2.Find sum of all elements
        int sum = Arrays.stream(nums).sum();
        System.out.println("sum is -> " + sum);
        System.out.println("--------------------------------------");

        //3.Find average
        double avg = Arrays.stream(nums).average().orElse(0.0);
        System.out.println("avg is -> " + avg);
        System.out.println("--------------------------------------");


        //4.🔹 4. Find maximum
        int maxElement = Arrays.stream(nums).max().orElse(10);
        System.out.println("max Element is -> " + maxElement);
        System.out.println("--------------------------------------");

        //5. Find Minimum
        int MinElement = Arrays.stream(nums).min().orElse(-1);
        System.out.println("min element is -> " + MinElement);
        System.out.println("--------------------------------------");

        //6. Count even numbers
        long cntEven = Arrays.stream(nums).filter(no -> no % 2 == 0).count();
        System.out.println("count evern no is ->" + cntEven);
        System.out.println("--------------------------------------");

        //7.Print only odd numbers
        Arrays.stream(nums).filter(no -> no % 2 != 0).forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------------------");

        //8.Multiply each element by 2
        Arrays.stream(nums).map(no -> no * 2).forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------------------");

        //9. Find distinct elements
        int[] arr = {1, 2, 2, 3, 4, 4,6};
        Arrays.stream(arr).distinct().forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------------------");

        //🔹 10. Sort array ascending
        Arrays.stream(arr).boxed().sorted().forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------------------");

        //11. Sort array descending
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------------------");

        //12.Find second highest number
        int SecondHighest = Arrays.stream(nums).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("SecondHighest is -> " +SecondHighest);
        System.out.println("--------------------------------------");

        //13.Find secondLowest NUmber
        int SecondLowest = Arrays.stream(nums).boxed().distinct().sorted().skip(1).findFirst().orElse(-1);
        System.out.println("SecondLowest number is -> " + SecondLowest);
        System.out.println("--------------------------------------");

        //14.Count how many elements > 5
        long count1 = Arrays.stream(nums).boxed().filter(no -> no > 5).count();
        //or         long count1 = Arrays.stream(nums).filter(no -> no > 5).count();    Without boxed()
        System.out.println("element is greater than 5 -> " + count1);
        System.out.println("--------------------------------------");

        //15. Check if all numbers are positive
        boolean checkAllPostive = Arrays.stream(nums).allMatch(no -> no % 2 == 0);
        System.out.println("checkAllPostive number -> " + checkAllPostive);
        System.out.println("--------------------------------------");


        //16. Check if any number is divisible by 5
        boolean anyNumber = Arrays.stream(nums).anyMatch(no -> no % 5 ==0 );
        System.out.println("any number is divisible by 5 -> " +anyNumber);
        System.out.println("--------------------------------------");


        //17.Convert int[] to List<Integer>
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        System.out.println("int[] to List<Integer> -> " + list);
        System.out.println("--------------------------------------");


        //18.Find square of each element
        Arrays.stream(nums).boxed().map(no -> no * 2).forEach(System.out::print);
        System.out.println("--------------------------------------");

        //19. Reverse array using streams
        List<Integer> reverse = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println(" Reverse array using streams -> " +reverse);
        System.out.println("--------------------------------------");

        //20.🔹 Skip first 2 elements and print rest
        Arrays.stream(nums).skip(2).forEach(System.out::print);
        System.out.println("--------------------------------------");

        //21.Limit to first 3 elements
        Arrays.stream(nums).limit(3).forEach(System.out::print);
        System.out.println("--------------------------------------");

        //22.Find first element greater than 2
        int firstElement = Arrays.stream(nums).filter(no -> no > 2).findFirst().orElse(-1);
        System.out.println("Find first element greater than 2 -> " +firstElement);
        System.out.println("--------------------------------------");

        //23.Calculate factorial of array elements using reduce
        int factorial = Arrays.stream(nums).reduce(1,(a,b) ->{ return a * b;});
        System.out.println("factorial of all nums -> " + factorial);
        System.out.println("--------------------------------------");

        //24.Convert int[] to comma-separated string
        String commaSeparetedString = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println("Convert int[] to comma-separated string -> " + commaSeparetedString);
        System.out.println("--------------------------------------");

        //25. Get summary statistics
        IntSummaryStatistics obj  = Arrays.stream(nums).summaryStatistics();
        System.out.println(obj);
        System.out.println("--------------------------------------");


        //26.Create int[] from List<Integer>
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);

        int[] created = list1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(created));

        List<Integer> lls = Arrays.stream(created).boxed().collect(Collectors.toList());

        //27 reverse int value
         int val = 123;
         int reversed = Integer.parseInt(new StringBuilder(String.valueOf(val)).reverse().toString());

        System.out.println(reversed);


        // 28 nullsFirst and nullsLast work only with objects,
        // not primitives, because primitives like int cannot store null."
        Integer demo[] = {1,null,2,null,3};
        Integer[] ans = Arrays.stream(demo).
                        sorted(Comparator.nullsFirst(Comparator.naturalOrder())).
                       toArray(Integer[]::new);
        System.out.println("NUlls first ->" + Arrays.toString(ans));

        //29 nullsLast
        Integer[] ans1 = Arrays.stream(demo).
                sorted(Comparator.nullsLast(Comparator.reverseOrder())).
                toArray(Integer[]::new);
        System.out.println("NUlls last ->" + Arrays.toString(ans1));































    }
}
