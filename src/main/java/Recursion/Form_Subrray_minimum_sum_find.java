package Recursion;


//Input: arr = [3,1,2,4]
//Output: 17
//Explanation:
//Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//Sum is 17.

import java.util.ArrayList;
import java.util.List;

public class Form_Subrray_minimum_sum_find {
    static int mod = (int)1e9+7;
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        int n = arr.length;

        List<Integer>list = new ArrayList<>();
        List<List<Integer>>put = new ArrayList<>();

        for(int i = 0 ;i<n;i++){
            subArrayForm(i,arr,list,put);
        }

        int total = 0 ;

        for(List<Integer>ls : put){
            int min = ls.stream().mapToInt(Integer::intValue).min().orElse(0);

            total = (total + min) % mod;
        }
        int finalans =  (int) total;

        System.out.println("final answer is -> " + finalans);
    }
    public static void subArrayForm(int index ,int arr[] , List<Integer>list,List<List<Integer>>put){
        if(index == arr.length) return ;

        list.add(arr[index]);
        put.add(new ArrayList<>(list));

        subArrayForm(index+1,arr,list,put);
        list.remove(list.size()-1);

    }
}
