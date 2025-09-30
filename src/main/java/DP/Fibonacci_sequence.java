package DP;

public class Fibonacci_sequence {
    public static void main(String[] args) {
        int n = 5;
        int ans =  fibo (n);
        System.out.print(ans);
    }
    public static int fibo(int n){
        if(n <=1) return n;

        int prev2 = 0 ;
        int prev = 1 ;

        for(int i = 2 ; i<=5;i++){
            int curr = prev2+prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
