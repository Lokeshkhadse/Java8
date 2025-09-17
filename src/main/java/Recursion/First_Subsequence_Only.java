package Recursion;

import java.util.ArrayList;
import java.util.List;

public class First_Subsequence_Only {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int i = 0 ;
        int target = 2;
        int sum = 0 ;
        List<Integer> list = new ArrayList<>();
         findSunsequence(arr,i,target ,sum ,list);



    }

    public static boolean findSunsequence(int arr[],int i, int target,int sum,List<Integer> list){
        if( i == arr.length){
            if(sum == target){
//             for(int num:list){
//                 System.out.print(num + " ");
//             }
                System.out.print(list);
                return true;
            }
            System.out.println();
            return false;
        }

        list.add(arr[i]);
        sum = sum + arr[i];
        if(findSunsequence(arr,i+1,target,sum , list) == true) return true;

        list.remove(list.size() -1);
        sum = sum - arr[i];
        if(findSunsequence(arr,i+1,target,sum,list) == true) return true;

        return false;
    }
}
