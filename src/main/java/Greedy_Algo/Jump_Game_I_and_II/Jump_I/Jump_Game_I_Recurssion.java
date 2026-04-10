package Greedy_Algo.Jump_Game_I_and_II.Jump_I;

public class Jump_Game_I_Recurssion {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        boolean res = canReach(arr, 0);
        System.out.println("result is -> " + res);
    }

    public  static boolean canReach(int[] arr, int index) {
        int n = arr.length;

        // ✅ Base Case: reached or crossed last index
        if(index >= n - 1) return true;

        // ❌ If value is 0 → can't move forward
        if(arr[index] == 0) return false;

        // 🔁 Try all possible jumps
        for(int jump = 1; jump <= arr[index]; jump++) {
            if(canReach(arr, index + jump)) {
                return true; // any one path works
            }
        }
        return false;
    }
}
