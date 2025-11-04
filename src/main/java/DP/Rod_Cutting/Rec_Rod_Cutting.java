package DP.Rod_Cutting;

public class Rec_Rod_Cutting {
    public static void main(String[] args) {
        int rod[] = {2,5,7,8,10};
        int n = 5;
        int index = rod.length-1;
        int ans = cuttingRodFun(index,rod,n);
        System.out.println(ans);
    }
    public static int cuttingRodFun(int index ,int[] rod,int n){
        if(index == 0){
            return n * rod[0]; // take as many 1-length pieces as possible
        }

        int notcutRod = 0 + cuttingRodFun(index-1,rod,n);
        int cutRod = Integer.MIN_VALUE;
        int rodlength = index+1;   // because 1-based length

        if( rodlength <= n){
            cutRod = rod[index] + cuttingRodFun(index,rod,n-rodlength);
        }

        return Math.max(notcutRod,cutRod);
    }
}
