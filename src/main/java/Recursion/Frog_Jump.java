package Recursion;

public class Frog_Jump {
    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int n = arr.length;
        int ans = minValueJump(arr,n-1);
        System.out.println("Minimum Energy: " + ans);
    }
    public static int minValueJump(int[] arr , int n){
        if(n == 0) return 0;

        int onestep = minValueJump(arr,n-1) + Math.abs(arr[n] - arr[n-1]);
        int twostep = Integer.MAX_VALUE ;
        if(n > 1){
            twostep = minValueJump(arr,n-2) + Math.abs(arr[n] - arr[n-2]);
        }

        return Math.min(onestep,twostep);
    }
}
