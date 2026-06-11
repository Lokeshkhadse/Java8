package BinarySearch.Serach_First_Last_Position;

import java.util.Arrays;

public class Serach_First_Last_Position {
    public static int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int first = -1;
        int last = -1;

        int low = 0;
        int high = n - 1;

        // Find first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Target not found
        if (first == -1) {
            return new int[]{-1, -1};
        }

        low = 0;
        high = n - 1;

        // Find last occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};

        System.out.println(Arrays.toString(searchRange(nums, 8))); // [3, 4]

        System.out.println(Arrays.toString(searchRange(nums, 6))); // [-1, -1]

        System.out.println(Arrays.toString(searchRange(nums, 7))); // [1, 2]

        System.out.println(Arrays.toString(searchRange(nums, 10))); // [5, 5]
    }
}