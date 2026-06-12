package BinarySearch.Find_minimum_in_rotated_sorted_array;

public class Find_minimum_in_rotated_sorted_array {
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            //left part sorted
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }//right part sorted
            else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4,5,1, 2};

        int minElement = findMin(nums);

        System.out.println("Minimum element in rotated sorted array: " + minElement);
    }
}
