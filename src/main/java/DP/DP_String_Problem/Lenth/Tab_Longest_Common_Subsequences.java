package DP.DP_String_Problem.Lenth;

public class Tab_Longest_Common_Subsequences {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";




        int m = s1.length();
        int n = s2.length();

        int ans = function(s1,s2,m,n);
        System.out.println("Tab_Longest_Common_Subsequences is --->" + ans);
    }
    public static int function(String s1,String s2,int m , int n){
        int[][] dp = new int[m+1][n+1];

        for(int i = 0;i<=m;i++) dp[i][0] = 0;
        for(int j = 0;j<=n;j++) dp[0][j] = 0 ;

        int max = 0;

        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];

    }
}
