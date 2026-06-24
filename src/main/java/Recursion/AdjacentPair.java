package Recursion;

public class AdjacentPair {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        findpairs(arr,0,1);
    }
    public static void findpairs(int arr[] , int i , int j){
        if(i >= arr.length-1){
            return ;
        }

        if(j >= arr.length){
            findpairs(arr,i+1,i+2);
            return ;
        }
        System.out.println(arr[i] + " " + arr[j]);
        findpairs(arr,i,j+1);
    }
}


