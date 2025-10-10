package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {            // it does not follow order , conti or not contigous ,
                                 // not add duplicate , [1,2] == [2,1] so add only one
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        List<List<Integer>> finalans  = function(arr);

        System.out.println(finalans);
    }

    public static List<List<Integer>> function(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        subsetFind(0,ans,list,arr);

        return ans;
    }

    public static void subsetFind(int index ,List<List<Integer>> ans, List<Integer>list,int[] arr){

        if(index == arr.length){

                ans.add(new ArrayList<>(list));
               return ;
        }

        list.add(arr[index]);
        subsetFind(index+1,ans,list,arr);

        list.remove(list.size()-1);
        subsetFind(index+1,ans,list,arr);
    }

}

       // remove duplicate [1,2] is allow [2,1] is dupli of[1,2] so remove it
//
//package Recursion;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Subset {
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 1};
//
//        List<List<Integer>> finalans = function(arr);
//
//        System.out.println(finalans);
//    }
//
//    public static List<List<Integer>> function(int[] arr) {
//        Arrays.sort(arr); // Sort once at start
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        subsetFind(0, ans, list, arr);
//        return ans;
//    }
//
//    public static void subsetFind(int index, List<List<Integer>> ans, List<Integer> list, int[] arr) {
//        ans.add(new ArrayList<>(list)); // Add subset at each recursion
//
//        for (int i = index; i < arr.length; i++) {
//            if (i > index && arr[i] == arr[i - 1]) continue; // Skip duplicate picks
//
//            list.add(arr[i]);
//            subsetFind(i + 1, ans, list, arr);
//            list.remove(list.size() - 1); // Backtrack
//        }
//    }
//}

