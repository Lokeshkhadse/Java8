package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {4,1,5,2,6,3};
        QuickSort(arr,0,arr.length-1);
        System.out.print(Arrays.toString(arr));
    }

    public static  void QuickSort(int arr[], int low , int high){
        if(low < high){
            int partitionIdx = partition(arr,low,high);

            QuickSort(arr,low,partitionIdx-1);
            QuickSort(arr,partitionIdx+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }
            while(arr[j] > pivot && j>=low+1){
                j--;
            }

            if(i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }
}
