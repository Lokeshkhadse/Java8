package IntArray;
import java.util.*;
import java.util.stream.IntStream;

public class intArray_java8_Hard {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 9, 3, 7};

        //1.Sliding window of size 3 and average
        IntStream.range(0,arr.length-2).mapToDouble(i  -> arr[i] + arr[i+1] + arr[i+2] / 3.0).forEach(System.out::println);
        System.out.println("--------------------------------");

        //2. Find all subarrays with sum 0
        int[] a = {1, 2, -3, 3, -3};
        Set<Integer> sumSet = new HashSet<>();
        int sum = 0;
        boolean hasZeroSumSubarray = false;
        for (int val : a) {
            sum += val;
            if (val == 0 || sum == 0 || sumSet.contains(sum)) {
                hasZeroSumSubarray = true;
                break;
            }
            sumSet.add(sum);
        }
        System.out.println("Has Zero Sum Subarray? " + hasZeroSumSubarray);
        System.out.println("sumSet " + sumSet);

        //3.Rearrange array so even index has even and odd index has odd
        int[] input = {3, 6, 12, 1, 5, 8};
        int[] result = new int[input.length];
        int evenIdx = 0, oddIdx = 1;
        for (int num : input) {
            if (num % 2 == 0 && evenIdx < input.length) result[evenIdx++] = num; evenIdx++;
            if (num % 2 != 0 && oddIdx < input.length) result[oddIdx++] = num; oddIdx++;
        }
        System.out.println(Arrays.toString(result));

    }
}

