package DP;

import java.util.HashMap;
import java.util.Map;

public class SubArray_sum_Equal_k {
    public static void main(String[] args) {
       int arr[] = {1,1,1};
       int k = 2;
       int cnt = function(arr,k);
        System.out.println(cnt);

    }
    public static int function(int[] arr , int k){
        int n  = arr.length;
        int cnt = 0 ;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int no:arr){
            sum = sum + no;

            if(map.containsKey(sum-k)){
                cnt = cnt + map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
