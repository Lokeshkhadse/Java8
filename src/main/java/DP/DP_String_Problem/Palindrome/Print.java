package DP.DP_String_Problem.Palindrome;

public class Print {
    public static void main(String[] args) {
        String s1 = "bbbcb";

        String s2 = new StringBuilder(s1).reverse().toString();

        String lcs = findLPS(s1, s2, s1.length() - 1, s2.length() - 1);
        System.out.println("Longest palindrpme Subsequence is -> " + new StringBuilder(lcs).reverse().toString());
        System.out.println("Length -> " + lcs.length());
    }

    public static String findLPS(String s1,String s2,int index1,int index2){

        //base case
        if(index1 < 0  || index2 < 0){
            return "";
        }

        //match
        if(s1.charAt(index1) == s2.charAt(index2)){
            return s1.charAt(index1) + findLPS(s1,s2,index1-1,index2-1);
        }
        //not match

        String left = findLPS(s1,s2,index1-1,index2);
        String right = findLPS(s1,s2,index1,index2-1);


        return (left.length() > right.length()) ? left : right;
    }
}
