package Normal_Code;

import java.util.Arrays;

public class Swap_Number {
    //Approach 1
    public static int[] Approach1(int a, int b){
        int temp = a;
        a = b;
        b = temp;

        return new int[]{a,b};
    }

    //Approach 2
    public static int[] Approach2(int a, int b){
        a = a^b;
        b = a^b;
        a= a^b;

        return new int[]{a,b};
    }
    //Approach 3
    public static int[] Approach3(int a, int b){
        a = a+b;
        b = a-b;
        a = a-b;

        return new int[]{a,b};
    }
    //Approach 4
    public static int[] Approach4(int a, int b){
       a = a*b;
       b = a/b;
       a = a/b;

        return new int[]{a,b};
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(Arrays.toString(Approach1(a,b)));
        System.out.println(Arrays.toString(Approach2(a,b)));
        System.out.println(Arrays.toString(Approach3(a,b)));
        System.out.println(Arrays.toString(Approach4(a,b)));



    }
}
