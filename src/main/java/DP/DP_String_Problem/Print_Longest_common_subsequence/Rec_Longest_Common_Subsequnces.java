package DP.DP_String_Problem.Print_Longest_common_subsequence;

import java.util.*;

public class Rec_Longest_Common_Subsequnces {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";

        List<String> a = formSubsequence(0, s1.toCharArray(), new StringBuilder(), new ArrayList<>());
        List<String> b = formSubsequence(0, s2.toCharArray(), new StringBuilder(), new ArrayList<>());

        // find common subsequences
        Set<String> setB = new HashSet<>(b);
        List<String> common = a.stream()
                .filter(setB::contains)
                .toList();

        // find longest one
        String longest = common.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("-1");

        System.out.println("All subsequences of s1: " + a);
        System.out.println("All subsequences of s2: " + b);
        System.out.println("Common subsequences: " + common);
        System.out.println("Longest Common Subsequence: " + longest);
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
