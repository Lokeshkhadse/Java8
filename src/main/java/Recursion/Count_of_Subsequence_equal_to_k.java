package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Count_of_Subsequence_equal_to_k {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int i = 0 ;
        int target = 2;
        int sum = 0 ;

        List<Integer> list = new ArrayList<>();
        int count = findSunsequence(arr,i,target ,sum ,list );
        System.out.print(count);


    }

    public static int findSunsequence(int arr[],int i, int target,int sum,List<Integer> list ){
        if( i == arr.length){
            if(sum == target){
                System.out.print(list);
                return 1;
            }
            System.out.println();
            return 0;
        }

        list.add(arr[i]);
        sum = sum + arr[i];
        int cntWith = findSunsequence(arr,i+1,target,sum , list);

        list.remove(list.size() -1);
        sum = sum - arr[i];
        int cntWithout = findSunsequence(arr,i+1,target,sum,list);

        return cntWith + cntWithout;
    }
}

