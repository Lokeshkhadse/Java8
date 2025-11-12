package DP.DP_String_Problem.Minimum_Insertion_deletion_toMake_Str1_To_Str2;

public class Rec2_Minimum_Insertion_deletion_toMake_Str1_To_Str2 {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";

        int m = s1.length();
        int n = s2.length();

        int ans = operation(s1, s2, m-1, n-1);
        System.out.println("Minimum_Insertion_deletion_toMake_Str1_To_Str2 is ---> " + ans);
    }

    // Recursive LCS function
    public static int operation(String s1, String s2, int m, int n) {
        // base cases
        if(m < 0) return n+1;
        if(n < 0) return m+1;

        // if last characters match
        if (s1.charAt(m ) == s2.charAt(n)) {
            return 0 + operation(s1, s2, m - 1, n - 1);
        }
        // if not match // perform insertion and deletion

        //insertion
        int insertion = 1 + operation(s1,s2,m,n-1);

        //deletion
        int deletion = 1 + operation(s1,s2,m-1,n);

        return Math.min(insertion,deletion);
    }
}
