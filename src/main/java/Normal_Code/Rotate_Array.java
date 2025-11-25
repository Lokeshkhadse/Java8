package Normal_Code;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};

        int k = 3;
        int n = arr.length;

        k = k % n;   // rotating reduce instead of using rotate mutiple time
                     // because of this it rotate particular time
                    //example: n = 7 , k = 100  => 100 % 7 = 2
                   //So rotating 100 times is SAME as rotating 2 times.

        int newarr[] = new int[k];
        int len = newarr.length;;

        for(int i = n-1;i>=n-k;i--){
            newarr[len-1] = arr[i];
            len--;
        }
        System.out.println(Arrays.toString(newarr));

        int finalarr[] = new int[n];

         int z = k;
        for(int i  = 0 ;i<n-k;i++){
            finalarr[z] = arr[i];
            z++;
        }
        System.out.println(Arrays.toString(finalarr));


        for(int i = 0;i<k;i++){
            finalarr[i] = newarr[i];
        }

        System.out.println(Arrays.toString(finalarr));
    }
}
