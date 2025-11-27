package DP.Partition_DP.Matrix_Chain_Multiplication;

public class Rec { //FIND MINIMAL MULTIPLICATION OPERATION
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50} ; //ABCD -> A *BCD , AB*CD , ABC*D
        int n = arr.length;

        int Startindex = 1;
        int EndIndex = n-1;

        int ans = func(Startindex,EndIndex,arr);
        System.out.println("MINIMAL MULTIPLICATION OPERATION  -> " + ans);
    }

    public static int func(int i , int j,int arr[]){
        if(i == j) return 0;

        int min = (int)1e9;

        for(int k = i ;k<j;k++){
            int cost = arr[i-1] * arr[k] * arr[j] + func(i,k,arr) + func(k+1,j,arr);

            min = Math.min(min,cost);
        }
        return min;
    }
}
