package DP.Buy_Sell_Problems.Buy_Sell_I;

public class I_Buy_Sell_Stock {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int n = arr.length;

        int buy = arr[0];
        int current = 0 ;
        int max = 0 ;

        for(int num : arr){
            if( num > buy){
                current = num -buy;
                max = Math.max(max,current);
            }else{
                buy = num;
            }
        }

        System.out.println("Buy_Sell_Stock is ->" + max);

        //2ND APPRAOCH

        // int max = 0 ;
        // for(int i = 0 ;i<prices.length-1;i++){
        //     int num = prices[i];
        //     for(int j = i+1;j<prices.length;j++){

        //           if( num < prices[j]){
        //                max = Math.max(max,prices[j]-num);
        //           }
        //     }
        // }
        // return max;
    }
}
