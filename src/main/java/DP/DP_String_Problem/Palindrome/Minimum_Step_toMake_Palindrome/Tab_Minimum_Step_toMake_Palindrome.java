package DP.DP_String_Problem.Palindrome.Minimum_Step_toMake_Palindrome;

public class Tab_Minimum_Step_toMake_Palindrome {
    public static void main(String[] args) {
        String s1 = "mbadm";

        String s2= new StringBuilder(s1).reverse().toString();

        int m = s1.length();
        int n = s2.length();

        int longestPalindromeLength = function(s1,s2,m,n);
        int ans = s1.length() - longestPalindromeLength;           //5-3    (mam,mbm,mdm is palindrome subsequences take any 1)
        System.out.println("Minimum_Step_toMake_Palindrome is -->" + ans);
    }

    public static int function(String s1, String s2,int m,int n){
        int dp[][] = new int[m+1][n+1];

        for(int i = 0 ;i<=m;i++) dp[i][0] = 0;
        for(int j = 0 ;j<=n;j++) dp[0][j] = 0;

        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0  + Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }
}
