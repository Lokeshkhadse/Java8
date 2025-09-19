package Recursion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortArray {     //tc:- O(n log n).
    public static void main(String[] args) {
        int arr[] = {3,1,2,8};
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortArr(int []arr){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0  ;i<arr.length;i++){
            queue.add(arr[i]);
        }

        for(int i = 0 ;i<arr.length;i++)
        {
            arr[i] = queue.poll();
        }
    }
}
