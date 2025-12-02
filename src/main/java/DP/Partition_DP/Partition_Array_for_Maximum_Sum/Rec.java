package DP.Partition_DP.Partition_Array_for_Maximum_Sum;

public class Rec {
    public static void main(String[] args) {
        int arr[] = {1,15,7,9,2,5,10};
        int k = 3;

        int index =0 ;
        int ans = func(index,arr,k);
        System.out.println("maximum sum after k partition is ->" + ans);
    }
    public static int func(int index,int arr[] , int k){
        if(index == arr.length){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxElement = 0;
        int len = 0;


        for(int j = index;j<Math.min(arr.length,index+k);j++){
            len++;
            maxElement = Math.max(maxElement,arr[j]);

            int sum = len * maxElement + func(j+1,arr,k);

            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
