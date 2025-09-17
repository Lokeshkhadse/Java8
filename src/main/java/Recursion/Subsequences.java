package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = 3;
        List<Integer> list = new ArrayList<>();
        int index = 0 ;
        formSubsequnece(index,arr,n,list);

    }

    public static void formSubsequnece(int index,int arr[] , int n,List<Integer>list){

        if (index == n) {
            if (list.size() == 0) {
                System.out.print("{} ");
            } else {
                for (int i : list) {
                    System.out.print(i + " ");
                }
                System.out.println(" ");
            }
            return;
        }

       // take or pick particular index or element into a subsequnece
        list.add(arr[index]);
        formSubsequnece(index+1,arr,n,list);
        list.remove(list.size() - 1);  //whatever element added that [last element] remove

        // not take or not pick index or element, this element is not added in subsequnce
        formSubsequnece(index+1,arr,n,list);

    }
}
