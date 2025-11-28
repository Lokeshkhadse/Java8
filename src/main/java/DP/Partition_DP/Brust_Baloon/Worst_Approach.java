package DP.Partition_DP.Brust_Baloon;

import java.util.ArrayList;
import java.util.List;

public class Worst_Approach {   //tc -> O(n! × n²)

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        List<List<Integer>> allPerms = new ArrayList<>();
        generatePermutations(nums, 0, allPerms);

        int maxCoins = 0;

        for (List<Integer> perm : allPerms) {
            int coins = simulate(new ArrayList<>(perm));
            maxCoins = Math.max(maxCoins, coins);
        }

        System.out.println("Maximum coins using brute force = " + maxCoins);
    }

    // Step 1: Generate all permutations
    static void generatePermutations(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            generatePermutations(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }

    // Step 2: Simulate bursting for a given permutation
    static int simulate(List<Integer> list) {
        int totalCoins = 0;

        while (!list.isEmpty()) {
            // always burst the first balloon (simple strategy)
            int idx = 0;

            int left = (idx - 1 >= 0) ? list.get(idx - 1) : 1;
            int right = (idx + 1 < list.size()) ? list.get(idx + 1) : 1;

            int coins = left * list.get(idx) * right;
            totalCoins += coins;

            list.remove(idx); // burst balloon
        }

        return totalCoins;
    }
}