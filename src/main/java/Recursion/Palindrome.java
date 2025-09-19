package Recursion;

public class Palindrome {
    public static void main(String[] args) {
        String str = "racecar";
        int i =  0 , j = str.length() - 1;
        boolean val = isPalindrome(str,i,j);
        System.out.println(val);
    }

    public static boolean isPalindrome(String str,int i, int j) {

       if(i >= j){
           return true;
       }
       if(str.charAt(i) == str.charAt(j)){
           return isPalindrome(str, i + 1, j - 1);
       }
       return false;
    }
}
