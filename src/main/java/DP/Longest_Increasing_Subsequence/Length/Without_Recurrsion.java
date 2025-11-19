package DP.Longest_Increasing_Subsequence.Length;

import java.util.ArrayList;
import java.util.List;

public class Without_Recurrsion {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));  // prints 4
    }

    public static int lengthOfLIS(int[] nums) {
        return findLTS(nums).size();
    }

    public static List<Integer> findLTS(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        for (int num : nums) {

            boolean appended = false;
            List<List<Integer>> newLists = new ArrayList<>();

            for (List<Integer> ll : list) {
                int last = ll.get(ll.size() - 1);

                if (num > last) {
                    List<Integer> newList = new ArrayList<>(ll);
                    newList.add(num);
                    newLists.add(newList);
                    appended = true;
                }
            }

            // if num could not be appended anywhere → start a new subsequence
            if (!appended) {
                List<Integer> newList = new ArrayList<>();
                newList.add(num);
                newLists.add(newList);
            }

            list.addAll(newLists);
        }

        // find longest subsequence
        List<Integer> best = new ArrayList<>();

        for (List<Integer> sub : list) {
            if (sub.size() > best.size()) {
                best = sub;
            }
        }
        return best;
    }


}
