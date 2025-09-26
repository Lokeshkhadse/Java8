package Recursion;

import java.util.*;

public class Count_Inversions {

    public static int inversionCount(int arr[]) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int cnt[] = new int[1]; // store inversion count

        function(arr, cnt, n, ans, list, 0);

        return cnt[0];
    }

    public static void function(int[] arr, int[] cnt, int n,
                                List<List<Integer>> ans, List<Integer> list,
                                int index) {

        if (list.size() == 2) {
            if (list.get(0) > list.get(1)) {
                ans.add(new ArrayList<>(list));
                cnt[0]++;
            }
            return;
        }

        if (index >= n) return;

        // Pick current element
        list.add(arr[index]);
        function(arr, cnt, n, ans, list, index + 1);

        // Backtrack: remove last element
        list.remove(list.size() - 1);

        // Skip current element
        function(arr, cnt, n, ans, list, index + 1);
    }

    //Another Approach
//    public static void function(int[] arr, int[] cnt, int n,
//                                List<List<Integer>> ans, List<Integer> list,
//                                int start) {
//
//        if (list.size() == 2) {
//            if (list.get(0) > list.get(1)) {
//                ans.add(new ArrayList<>(list));
//                cnt[0]++;
//            }
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            list.add(arr[i]);
//            function(arr, cnt, n, ans, list, i + 1); // ensure order i < j
//            list.remove(list.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Inversion count: " + inversionCount(arr)); // Output: 3
    }
}
