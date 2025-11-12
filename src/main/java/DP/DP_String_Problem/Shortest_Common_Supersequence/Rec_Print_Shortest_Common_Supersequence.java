package DP.DP_String_Problem.Shortest_Common_Supersequence;

public class Rec_Print_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        String scs = shortestSupersequence(s1, s2, s1.length(), s2.length());
        System.out.println("Shortest Common Supersequence is --> " + scs);
    }

    public static String shortestSupersequence(String s1, String s2, int m, int n) {
        // Base cases
        if (m == 0) return s2.substring(0, n);  // if s1 is empty, return s2
        if (n == 0) return s1.substring(0, m);  // if s2 is empty, return s1

        // If last characters match → include it once
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return shortestSupersequence(s1, s2, m - 1, n - 1) + s1.charAt(m - 1);
        }

        // If they don't match → choose the smaller one recursively
        String option1 = shortestSupersequence(s1, s2, m - 1, n) + s1.charAt(m - 1);
        String option2 = shortestSupersequence(s1, s2, m, n - 1) + s2.charAt(n - 1);

        // Return whichever gives smaller length
        if (option1.length() < option2.length()) {
            return option1;
        } else {
            return option2;
        }
    }
}
