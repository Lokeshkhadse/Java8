package DP.SubsetSumEqulaToK;

public class Rec_SubsetSumEqualsToK {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int target = 4;

        boolean ans = subsetSumToK(arr.length-1,target,arr);
        System.out.println(ans);

    }
    public static boolean subsetSumToK(int index, int target, int arr[]){
        if(target == 0 ) return true;
        if(index == 0) return arr[0] == target;

        boolean notTake = subsetSumToK(index-1,target,arr);
        boolean take = false;

        if(arr[index] <=  target){
            take = subsetSumToK(index-1,target-arr[index],arr);
        }
        return notTake || take;

    }


}
