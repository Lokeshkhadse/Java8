package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PairSum_Rec {
    public static void findPairs(int arr[] , int target, int i , int j ,List<List<Integer>> mainlist){
        if(i >= arr.length){
            return ;
        }
        if(j >= arr.length){
            findPairs(arr,target,i+1,i+2,mainlist);  //i and j moves when j reaches end
            return ;
        }

        if(arr[i] + arr[j] == target){
            List<Integer> pair = new ArrayList<>();

            pair.add(arr[i]);
            pair.add(arr[j]);

            mainlist.add(pair);
        }

        // Recursive Call
        findPairs(arr, target, i, j + 1, mainlist);
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        int target = 5;

        List<List<Integer>> ans = new ArrayList<>();

        findPairs(arr, target, 0, 1, ans);

        System.out.println(ans);
    }
}
