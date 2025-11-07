package DP.DP_String_Problem.Substring;

import java.util.*;

public class Rec_Longest_Common_Substring {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        int ans = function(s1,s2);
        System.out.println("Longest_Common_Substring is --->" + ans);
    }
    public static int function(String s1,String s2){
        int max =Integer.MIN_VALUE;

        for(int i = 0 ;i<s1.length();i++){
            for(int j = i+1;j<=s1.length();j++){
                String sub  = s1.substring(i,j);

                if(s2.contains(sub)){
                    int length= sub.length();
                    max = Math.max(max,length);
                }else{
                    break;
                }
            }
        }
        return max;

    }
}


