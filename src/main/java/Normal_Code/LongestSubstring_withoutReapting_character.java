package Normal_Code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubstring_withoutReapting_character {

    // 🔴 1. Brute Force Approach - O(n^2)
    public static int bruteForce(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (!set.contains(ch)) {
                    set.add(ch);
                    maxLen = Math.max(maxLen, set.size());
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    // 🟡 2. Better Approach (LinkedList) - O(n^2)
    public static int betterApproach(String s) {
        int max = 0;
        List<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (list.contains(ch)) {
                list.remove(0);
            }

            list.add(ch);
            max = Math.max(max, list.size());
        }

        return max;
    }

    // 🟢 3. Optimal Approach (HashSet Sliding Window) - O(n)
    public static int optimal(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    // 🚀 MAIN METHOD (PSVM)
    public static void main(String[] args) {
        String s = "pwwkew";

        System.out.println("Input: " + s);

        int res1 = bruteForce(s);
        int res2 = betterApproach(s);
        int res3 = optimal(s);

        System.out.println("Brute Force Output: " + res1);
        System.out.println("Better (LinkedList) Output: " + res2);
        System.out.println("Optimal (HashSet) Output: " + res3);
    }
}
