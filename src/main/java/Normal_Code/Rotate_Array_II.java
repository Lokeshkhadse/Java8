package Normal_Code;

import java.util.Arrays;

public class Rotate_Array_II {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        int n = arr.length;

        k = k % n;   // rotating reduce instead of using rotate mutiple time
                     // because of this it rotate particular time
                    //example: n = 7 , k = 100  => 100 % 7 = 2
                   //So rotating 100 times is SAME as rotating 2 times.

        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] arr , int k){
        int n = arr.length;

        reverse(arr,0,n-1);

        reverse(arr,0,k-1);

        reverse(arr,k,n-1);
    }

    public static void reverse(int arr[],int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
