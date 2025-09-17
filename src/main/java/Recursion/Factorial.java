package Recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int prod = 1;
        int ans = fact(n,prod);
        System.out.print(ans);
    }
    public static int fact(int n , int prod){
        if(n == 0) return 1;

        prod = prod * n;

        return n * fact(n-1,prod);
    }

}
