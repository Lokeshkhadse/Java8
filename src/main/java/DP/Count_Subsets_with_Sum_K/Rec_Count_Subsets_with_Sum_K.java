package DP.Count_Subsets_with_Sum_K;


public class Rec_Count_Subsets_with_Sum_K {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int target = 4;

        int cnt =  subsetSumToK(arr.length-1,target,arr);
        System.out.println(cnt);

    }
    public static int subsetSumToK(int index,int target,int[] arr){
         if(target == 0) return 1;

         if(index == 0) return (arr[index] == target) ? 1: 0;

        int nottakecnt = subsetSumToK(index-1,target,arr);
        int takecnt = 0;

        if(arr[index] <= target){
            takecnt = subsetSumToK(index-1,target-arr[index],arr);
        }
        return nottakecnt + takecnt;
    }
}
