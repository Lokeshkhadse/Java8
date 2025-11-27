package DP.Partition_DP.Matrix_Chain_Multiplication;

public class Tab { //FIND MINIMAL MULTIPLICATION OPERATION
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50} ; //ABCD -> A *BCD , AB*CD , ABC*D
        int n = arr.length;


        int ans = func(arr);
        System.out.println("MINIMAL MULTIPLICATION OPERATION  -> " + ans);
    }

    public static int func(int arr[]){
        int n = arr.length;

        int dp[][] = new int[n][n];

        for(int i =1;i<n;i++){
            dp[i][i] = 0 ;
        }

        for(int i = n-1;i>=1;i--){
            for(int j = i+1;j<n;j++){
                int mini = (int)1e9;

                for(int k = i;k<j;k++){
                    int cost = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];

                    mini = Math.min(mini,cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
}
