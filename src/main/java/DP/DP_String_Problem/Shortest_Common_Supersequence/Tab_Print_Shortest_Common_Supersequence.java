package DP.DP_String_Problem.Shortest_Common_Supersequence;

public class Tab_Print_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        String ans    =  shortestSupersequence(s1,s2);
        
        System.out.println("Shortest_Common_Supersequence is -->" + ans);

    }
    public static String shortestSupersequence(String a, String b) {
        int m = a.length();
        int n = b.length();

        int dp[][] = new int[m+1][n+1];

        for(int i = 0 ;i<=m;i++) dp[i][0] = 0 ;
        for(int j = 0;j<=n;j++) dp[0][j] = 0 ;

        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(a.charAt(i-1)== b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        String ans ="";
        int i = m , j = n;

        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans = ans + a.charAt(i-1);
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                ans = ans + a.charAt(i-1);
                i--;
            }else{
                ans = ans + b.charAt(j-1);
                j--;
            }
        }

        while(i > 0){
            ans = ans + a.charAt(i-1);
            i--;
        }

        while(j > 0){
            ans = ans + b.charAt(j-1);
            j--;
        }

        return new StringBuilder(ans).reverse().toString();
    }
}
