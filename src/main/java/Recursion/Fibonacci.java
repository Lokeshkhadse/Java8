package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int ans = fibo(n);
        System.out.print(ans);
    }
    public static int fibo(int n){
        if(n <= 1) return n;

        return fibo(n-1) + fibo(n-2);
    }
}

//public static int fibo(int n) {
//    if (n <= 1) {
//        return n;
//    }
//
//    int a = 0;  // fib(0)
//    int b = 1;  // fib(1)
//    int fib = 0;
//
//    for (int i = 2; i <= n; i++) {
//        fib = a + b;  // Current Fibonacci number
//        a = b;       // Move forward
//        b = fib;
//    }
//
//    return fib;
//}