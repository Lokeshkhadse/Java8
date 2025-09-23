package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
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
