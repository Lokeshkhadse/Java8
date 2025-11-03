package DP.Knapsack_problem;

public class Rec_Knapsack_problem {
    public static void main(String[] args) {
        int[] weight = {2, 3, 5};
        int[] value = {50, 40, 60};

        int bagWeight = 6;
        int n = weight.length;

        int ans = function(n-1,weight,value,bagWeight);
        System.out.println(ans);

    }
    public static int function(int index , int[] weight,int[] value,int bagWeight){
        if(index == 0){
            if(weight[index] <= bagWeight){
                return value[index];
            }else{
                return 0;
            }
        }

        int nottake = 0 + function(index-1,weight,value,bagWeight);

        int take = Integer.MIN_VALUE;
        if(weight[index] <= bagWeight){
            take = value[index] + function(index-1,weight,value , bagWeight - weight[index]);
        }

        return Math.max(nottake,take);
    }
}
