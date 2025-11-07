package DP.DP_String_Problem.Substring;

public class Tab_Longest_Common_Substring {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        int m = s1.length();
        int n = s2.length();

        int ans = function(s1,s2,m,n);
        System.out.println("Longest_Common_Substring is --->" + ans);
    }
    public static int function(String s1,String s2,int m , int n){
        int[][] dp = new int[m+1][n+1];

        for(int i = 0;i<=m;i++) dp[i][0] = 0;
        for(int j = 0;j<=n;j++) dp[0][j] = 0 ;

        int max = 0;

        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return max;

    }
}

//
//                     0    1     2     3     4     5
//| s1\s2 |              |  a  |  c  |  j  |  k  |  p  |
//  0      | :---- | 0   | 0   | 0   | 0   | 0   | 0   |
//  1      | **a** |  0  |  1  |  0  |  0  |  0  |  0  |
//  2      | **b** |  0  |  0  |  0  |  0  |  0  |  0  |
//  3      | **c** |  0  |  0  |  1  |  0  |  0  |  0  |
//  4      | **j** |  0  |  0  |  0  |  2  |  0  |  0  |
//  5      | **k** |  0  |  0  |  0  |  0  |  3  |  0  |
//  6      | **l** |  0  |  0  |  0  |  0  |  0  |  0  |
//  7      | **p** |  0  |  0  |  0  |  0  |  0  |  1  |


