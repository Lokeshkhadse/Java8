package BinarySearch.LowerUpperBound;

public class Lower_Upper_Bound {
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,8,8,8,10,12};
        int target = 8;
        int ans = arr.length;

        int low = 0 ;
        int high = arr.length-1;

        int lower_bound = lower_bound(arr,target,low,high,ans);
        if(lower_bound == -1) System.out.println("Element not found in the array");
        else System.out.println("Lower bound of the element is at index: "+lower_bound);

        int upper_bound = upper_bound(arr,target,low,high,ans);
        if(upper_bound == -1) System.out.println("Element not found in the array");
        else System.out.println("Upper bound of the element is at index: "+upper_bound);
    }

    //Lower bound
    public static int lower_bound(int[] arr,int target, int low , int high,int ans){
        if(low > high){
            return ans;
        }
        int mid = low + (high - low) /2;

        if(arr[mid] >= target){
            ans = mid;
          return lower_bound(arr,target,low,mid-1,ans);
        }
        return lower_bound(arr,target,mid+1,high,ans);
    }

    //Upper bound
    public static int upper_bound(int[] arr,int target, int low , int high,int ans){
        if(low > high) {
            return ans;
        }
        int mid = low + (high - low) /2;

        if(arr[mid] > target){
            ans = mid;
          return upper_bound(arr,target,low,mid-1,ans);
        }
        return upper_bound(arr,target,mid+1,high,ans);
        }
}
