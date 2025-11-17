package DP.Buy_Sell_Problems.Buy_Sell_II;

public class II_Buy_Sell_Stock {
    public static void main(String[] args) {
//        int arr[] = {7,1,5,3,6,4};
        int arr[] = {7,1,5,8,6,4};

        int n = arr.length;

        int totalProfit = 0;

        for(int i = 0 ;i<n-1;i++){
            if(arr[i] < arr[i+1]){
                totalProfit = totalProfit + arr[i+1] - arr[i];
            }
        }

        System.out.println(totalProfit);
    }

}
