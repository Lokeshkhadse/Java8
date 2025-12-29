package Stack_Queue.Sum_SubArray_Minimum;


//Input: arr = [3,1,2,4]
//Output: 17
//Explanation:
//Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//Sum is 17.

import java.util.ArrayList;
import java.util.List;

public class Using_2_for_loop {
    static int mod = (int)1e9+7;
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        int n = arr.length;

        int sum = 0 ;

        for(int i = 0 ;i<n;i++){
            int min = arr[i];

            for(int j = i;j<n;j++){
                min = Math.min(min,arr[j]);
                sum = (sum + min) % mod;
            }
        }

        int finalans = (int) sum;
        System.out.println("final answer is -> " + finalans);


    }
}
