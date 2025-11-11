package DP.DP_String_Problem.Shortest_Common_Supersequence;

public class Rec_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        int index1 = s1.length();
        int index2 = s2.length();

        int lcs_cnt  =  function_lcs(s1,s2,index1-1,index2-1);
        int totallengthcnt = index1 + index2;
        int final_ans = totallengthcnt-lcs_cnt;

        System.out.println("Shortest_Common_Supersequence is -->" + final_ans);

    }
    public static int function_lcs(String s1, String s2,int index1,int index2){

        if(index1 < 0 || index2 < 0){
            return 0;
        }
        //match
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + function_lcs(s1,s2,index1-1,index2-1);
        }

        //not match and max return compare s1 character with s2 and s2 with s1
        return 0 + Math.max(function_lcs(s1,s2,index1-1,index2),function_lcs(s1,s2,index1,index2-1));
    }
}
