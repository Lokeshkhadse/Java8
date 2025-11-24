package DP.longest_Bitonic_Sequence.Length;

public class Tab_Longest_Bitonic_Sequence {

    public static void main(String[] args) {
        int[] nums = {33 ,26, 38, 53, 58, 92};
        System.out.println("Longest Bitonic Sequence -> " + longestBitonicSequence(nums));
    }

    public static int longestBitonicSequence(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];  // increasing
        int[] lds = new int[n];  // decreasing

        // Step 1: Compute LIS ending at each index
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Compute LDS starting at each index
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Combine LIS + LDS for each peak
        int max = 0;
        for (int i = 0; i < n; i++) {

            // must have: LIS >=2 AND LDS >=2
            if (lis[i] > 1 && lds[i] > 1) {
                max = Math.max(max, lis[i] + lds[i] - 1);
            }
        }

        return max;
    }
}
