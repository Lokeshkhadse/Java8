package DP.Knapsack_Infinite_Index_problem;

public class Rec_Knapsack_Infinite_Index_problem {
    public static void main(String[] args) {
//        int[] weight = {2, 3, 5};
//        int[] value = {50, 40, 60};
//
//        int bagWeight = 6;

        int[] weight = {5, 10, 15};
        int[] value = {10, 30, 20};
        int bagWeight = 20;

        int n = weight.length;

        int ans = function(n-1,weight,value,bagWeight);
        System.out.println(ans);

    }
    public static int function(int index , int[] weight,int[] value,int bagWeight){
        if(index == 0){
            if(  weight[index] <= bagWeight){
                if( bagWeight % weight[index]  == 0) {
                    return value[index] * bagWeight / weight[index];
                }else{
                    return value[index];
                }
            }else{
                return 0;
            }
        }

        int nottake = 0 + function(index-1,weight,value,bagWeight);

        int take = Integer.MIN_VALUE;
        if(weight[index] <= bagWeight){
            take = value[index] + function(index,weight,value , bagWeight - weight[index]);
        }

        return Math.max(nottake,take);
    }
}
