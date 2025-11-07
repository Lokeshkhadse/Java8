package DP.DP_String_Problem.Palindrome;

import java.util.*;

public class Rec_Longest_Palindrome_Subsequnces {
    public static void main(String[] args) {
        String s2 = "dcadb";

        List<String> a = formSubsequence(0, s2.toCharArray(), new StringBuilder(), new ArrayList<>());


        // find palindrome and max length

       String max_length_palindrome = a.stream()
                                      .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                                      .max(Comparator.comparingInt(String::length))
                                      .orElse("");



        System.out.println("All subsequences of s2: " + a);

        System.out.println("Longest palindrome Subsequence: " + max_length_palindrome);
    }

    public static List<String> formSubsequence(int index, char[] arr, StringBuilder current, List<String> ans) {
        if(index == arr.length){
            ans.add(current.toString());
            return ans;
        }
        // take
        current.append(arr[index]);
        formSubsequence(index + 1, arr, current, ans);
        current.deleteCharAt(current.length() - 1);

        // not take
        formSubsequence(index + 1, arr, current, ans);

        return ans;
    }
}
