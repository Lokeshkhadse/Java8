package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblem {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int i = 0 ;
        int target = 2;
        int sum = 0 ;
        List<Integer> list = new ArrayList<>();
        findSunsequence(arr,i,target ,sum ,list);


    }

    public static void findSunsequence(int arr[],int i, int target,int sum,List<Integer> list){
       if( i == arr.length){
          if(sum == target){
//             for(int num:list){
//                 System.out.print(num + " ");
//             }
              System.out.print(list);
          }
          System.out.println();
          return;
       }

       list.add(arr[i]);
       sum = sum + arr[i];
       findSunsequence(arr,i+1,target,sum , list);

       list.remove(list.size() -1);
       sum = sum - arr[i];
       findSunsequence(arr,i+1,target,sum,list);
    }
}


