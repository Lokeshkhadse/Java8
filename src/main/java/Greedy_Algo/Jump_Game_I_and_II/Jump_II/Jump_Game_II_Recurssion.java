package Greedy_Algo.Jump_Game_I_and_II.Jump_II;

public class Jump_Game_II_Recurssion {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        int res = canReach(arr, 0);
        System.out.println("result is -> " + res);
    }

    public  static int canReach(int[] arr, int index) {
        int n = arr.length;

        // ✅ Base Case: reached or crossed last index
        if(index >= n - 1) return 1;


        if(arr[index] == 0) return Integer.MAX_VALUE;

        int minSteps = Integer.MAX_VALUE;

        // 🔁 Try all possible jumps
        for(int jump = 1; jump <= arr[index]; jump++) {
            int steps = canReach(arr, index + jump);

            if(steps != Integer.MAX_VALUE){
                minSteps = Math.min(minSteps,1+steps);
            }
        }
        return minSteps;
    }
}
