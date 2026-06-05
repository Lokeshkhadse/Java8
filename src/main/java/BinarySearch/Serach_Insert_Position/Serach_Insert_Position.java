package BinarySearch.Serach_Insert_Position;

public class Serach_Insert_Position {
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,8,10,12};
        int target = 13;
        int n = arr.length;

        int position = searchInsertHashMapApproach(arr,target,n);

        System.out.println("Element can be inserted at index: "+position);

        int position2 = LowerboundApproach(arr,target,n);
        System.out.println("Element can be inserted at index: "+position);

    }

    public static int searchInsertHashMapApproach(int arr[],int target,int n){
        int lowIndex = -1;
        int highIndex = -1;

        for(int i = 0 ;i<n;i++){
            if(arr[i] == target){
                return i;
            }else if(arr[i] < target){
                lowIndex = i;lowIndex = i;
            }else{
                highIndex = i;
                break;
            }
        }
        if(arr[n-1] < target){
            return n;
        }
        return highIndex;
    }

    //lower Bound Approach
    public static int LowerboundApproach(int arr[],int target,int n){
        int ans = n;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
