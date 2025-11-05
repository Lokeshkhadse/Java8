package DP.DP_String_Problem.Lenth;

public class Int_Rec_Longest_Common_Subsequnces {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";

        int index1 = s1.length();
        int index2 = s2.length();

         int longestCommonSubsequenceLength = formSubsequence(s1,s2,index1-1,index2-1);
        System.out.println("longestCommonSubsequenceLength is ->" +longestCommonSubsequenceLength);

    }

    public static int formSubsequence(String s1,String s2,int index1 , int index2) {

        if(index1 < 0 || index2 < 0){
            return 0;
        }

        //Match
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + formSubsequence(s1,s2,index1-1,index2-1);
        }

        //not match and max return
        return 0 + Math.max(formSubsequence(s1,s2,index1-1,index2),formSubsequence(s1,s2,index1,index2-1));
    }
}
