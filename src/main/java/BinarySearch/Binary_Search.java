package BinarySearch;

public class Binary_Search {
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,8,10,12};
        int target = 8;
        int n = arr.length;

        int position = binarysearch(arr,target,n);

        if(position == -1) System.out.println("Element not found in the array");
        else System.out.println("Element found at index: "+position);

        int low = 0 ;
        int high = n-1;

        int position2 = recurssion_approach(arr,low,high,target);
        if(position2 == -1) System.out.println("Element not found in the array");
        else System.out.println("Element found at index: "+position2);
    }

    //Normal Approach
    public static int binarysearch(int[] arr,int target,int n){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low) /2 ;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

        //Recursive Approach
    public static int recurssion_approach(int[] arr, int low, int high, int target){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low) / 2;

        if(arr[mid] == target){
            return mid;
        }else if(target > arr[mid]){
            return recurssion_approach(arr,mid+1,high,target);
        }
        return recurssion_approach(arr,low,mid-1,target);

    }
}
