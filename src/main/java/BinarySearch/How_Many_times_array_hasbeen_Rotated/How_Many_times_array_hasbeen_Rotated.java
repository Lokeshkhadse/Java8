package BinarySearch.How_Many_times_array_hasbeen_Rotated;

public class How_Many_times_array_hasbeen_Rotated {

    // Approach 1: Brute Force
    public static int countRotationsBruteForce(int[] arr) {

        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Approach 2: Binary Search (Optimal)
    public static int countRotationsBinarySearch(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        int ans = Integer.MAX_VALUE;
        int pos = 0;

        while (low <= high) {

            // If entire search space is already sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    pos = low;
                }
                break;
            }

            int mid = low + (high - low) / 2;

            // Left half sorted
            if (arr[low] <= arr[mid]) {

                if (arr[low] < ans) {
                    ans = arr[low];
                    pos = low;
                }

                low = mid + 1;
            }
            // Right half sorted
            else {

                if (arr[mid] < ans) {
                    ans = arr[mid];
                    pos = mid;
                }

                high = mid - 1;
            }
        }

        return pos;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        int rotationsBrute = countRotationsBruteForce(nums);
        int rotationsBinary = countRotationsBinarySearch(nums);

        System.out.println("Brute Force Rotation Count : " + rotationsBrute);
        System.out.println("Binary Search Rotation Count : " + rotationsBinary);
        System.out.println(5 + "3");
    }
}