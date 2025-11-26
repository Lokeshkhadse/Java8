package Recursion;

public class Perform_Operation {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int n = arr.length;
        int ans = func(0,arr);
        System.out.println(ans);
    }
    public static int func(int index, int[] arr){
        if(index == arr.length-1){
            return arr[index];
        }

        //add
        int add = arr[index]  + func(index+1,arr);
        int sub = arr[index] - func(index+1,arr);
        int div = func(index+1,arr) != 0 ? arr[index] / func(index+1,arr) : Integer.MIN_VALUE;
        int multi = arr[index] * func(index+1,arr);

        return Math.max(add,Math.max(sub,Math.max(div,multi)));
    }

}
