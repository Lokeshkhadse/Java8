package Recursion;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int i = 0 ;
        int j = arr.length -1;
        reverse(arr,i,j);
        System.out.print(Arrays.toString(arr));

    }

    public static void reverse(int arr[],int i, int j){
        if(i >= j){
            return ;
        }
        int swap = arr[j];
        arr[j] = arr[i];
        arr[i] = swap;

        reverse(arr,i+1,j-1);

    }
}
