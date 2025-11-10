package DP.DP_String_Problem.Minimum_Insertion_deletion_toMake_Str1_To_Str2;

public class Rec_Minimum_Insertion_deletion_toMake_Str1_To_Str2 {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";

        int m = s1.length();
        int n = s2.length();

        int lcs = lcsRecursive(s1, s2, m-1, n-1);
        int ans = (m - lcs) + (n - lcs);
        System.out.println("Minimum_Insertion_deletion_toMake_Str1_To_Str2 is ---> " + ans);
    }

    // Recursive LCS function
    public static int lcsRecursive(String s1, String s2, int m, int n) {
        // base cases
        if (m < 0 || n < 0)
            return 0;

        // if last characters match
        if (s1.charAt(m ) == s2.charAt(n)) {
            return 1 + lcsRecursive(s1, s2, m - 1, n - 1);
        }
        // if not match — skip one char either from s1 or s2
        return 0 + Math.max(lcsRecursive(s1,s2,m-1,n),lcsRecursive(s1,s2,m,n-1));
    }
}
