package Recursion;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        System.out.println("Before Sorting: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After Sorting: " + Arrays.toString(arr));
    }

    // Merge Sort function
    public static void mergeSort(int[] arr, int low, int high){

        if(low == high) {
            return;
        }
            int mid = low + (high - low) /2;

            mergeSort(arr,low,mid);

            mergeSort(arr,mid +1,high);

            merge(arr,low,mid,high);

    }

    // Merge two sorted subarrays
    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int temp[] = new int[high - low + 1];
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low+i] = temp[i];
        }
    }

}
