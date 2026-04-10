package Greedy_Algo.Jump_Game_I_and_II.Jump_I;

public class Jump_Game_I {
    public static void main(String[] args) {
//        int arr[] = {2,3,1,1,4};
        int arr[] = {1,2,3,1,1,0,2,5};
        boolean res = Is_Reach_To_The_LastIndex(arr);
        System.out.println("result is -> " + res);
    }

    public static boolean Is_Reach_To_The_LastIndex(int[] arr) {
        int n = arr.length;

        int maxreach = 0 ;

        for(int i = 0;i<n;i++){
            if(maxreach < i) return false;

            maxreach = Math.max(maxreach,i+arr[i]);

            if(maxreach >= n-1) return true;
        }
        return false;
    }
}


