package Recursion;

import java.util.*;

public class Print_Subsequence_String {

    public static void printSubsequences(String input) {
        char[] arr = input.toCharArray();
        int n = arr.length;
        int index = 0;
        List<Character> list = new ArrayList<>();
        subsequences(index, arr, n, list);
    }

    public static void subsequences(int index, char[] arr, int n, List<Character> list) {
        if (index == n) {
            if (list.size() == 0) {
                System.out.println("");
            } else {
                for (char c : list) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }

        // Include current character
        list.add(arr[index]);
        subsequences(index + 1, arr, n, list);
        list.remove(list.size() - 1);

        // Exclude current character
        subsequences(index + 1, arr, n, list);
    }

    public static void main(String[] args) {
        String input = "abc";
        printSubsequences(input);
    }
}
