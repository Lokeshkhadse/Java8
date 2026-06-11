package BinarySearch.Search_in_Rotated_Sorted_Array;

public class Search_in_Rotated_Sorted_Array {

    public static int search(int[] arr, int target) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {

                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

       // int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int arr[] = {1,0,1,1,1};

        System.out.println("Index of 0: " + search(arr, 0));
     //   System.out.println("Index of 6: " + search(arr, 6));
      //  System.out.println("Index of 3: " + search(arr, 3));
      //  System.out.println("Index of 10: " + search(arr, 10));
    }
}