package DP.DP_String_Problem.Print_Longest_common_subsequence;

public class Rec1_Longest_Common_Subsequnces {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";

        String lcs = findLCS(s1, s2, s1.length() - 1, s2.length() - 1);
        System.out.println("Longest Common Subsequence is -> " + new StringBuilder(lcs).reverse().toString());
        System.out.println("Length -> " + lcs.length());
    }

    public static String findLCS(String s1,String s2,int index1,int index2){

        //base case
        if(index1 < 0  || index2 < 0){
            return "";
        }

        //match
        if(s1.charAt(index1) == s2.charAt(index2)){
            return s1.charAt(index1) + findLCS(s1,s2,index1-1,index2-1);
        }
        //not match

        String left = findLCS(s1,s2,index1-1,index2);
        String right = findLCS(s1,s2,index1,index2-1);


        return (left.length() > right.length()) ? left : right;
    }
}
