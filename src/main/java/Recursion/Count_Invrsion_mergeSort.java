package Recursion;

public class Count_Invrsion_mergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        int cnt = mergeSort(arr, 0, arr.length - 1);

        System.out.print("Inversion Count: " + cnt);
    }

    // Merge Sort function
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) {
            return cnt;
        }
        int mid = low + (high - low) / 2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    // Merge two sorted subarrays
    public static int merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int temp[] = new int[high - low + 1];
        int k = 0;
        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1); // Count inversions
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return cnt;
    }
}
