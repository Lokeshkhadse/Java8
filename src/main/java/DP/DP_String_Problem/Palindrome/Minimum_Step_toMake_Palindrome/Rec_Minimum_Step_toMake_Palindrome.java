package DP.DP_String_Problem.Palindrome.Minimum_Step_toMake_Palindrome;

public class Rec_Minimum_Step_toMake_Palindrome {
    public static void main(String[] args) {
//        String s1 = "bbbcb";
        String s1 = "mbadm";    //[2] String can be "mbdadbm" or "mdbabdm".


        String s2 = new StringBuilder(s1).reverse().toString();

        int index1 = s1.length();
        int index2 = s2.length();

        int Longest_Palindrome_Subsequences = formSubsequence(s1,s2,index1-1,index2-1);
        int ans = s1.length() - Longest_Palindrome_Subsequences;
        System.out.println("Minimum_Step_toMake_Palindrome is ->" + ans);

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

