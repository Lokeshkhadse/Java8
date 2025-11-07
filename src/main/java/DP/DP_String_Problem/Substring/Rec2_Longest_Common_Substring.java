package DP.DP_String_Problem.Substring;

public class Rec2_Longest_Common_Substring {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        int ans = longestCommonSubstring(s1, s2, s1.length() - 1, s2.length() - 1, 0);
        System.out.println("Longest Common Substring length is ---> " + ans);
    }

    public static int longestCommonSubstring(String s1, String s2, int index1, int index2, int count) {

        if (index1 < 0 || index2 < 0) {
            return count;
        }

        int currentCount = count;

        // ✅ If characters match — increase count and go diagonally
        if (s1.charAt(index1) == s2.charAt(index2)) {
            currentCount = longestCommonSubstring(s1, s2, index1 - 1, index2 - 1, count + 1);
        }

        // ❌ When mismatch — reset count to 0 but continue searching
        int left = longestCommonSubstring(s1, s2, index1 - 1, index2, 0);
        int right = longestCommonSubstring(s1, s2, index1, index2 - 1, 0);

        // Return the maximum among current matching substring, left, and right
        return Math.max(currentCount, Math.max(left, right));
    }
}
