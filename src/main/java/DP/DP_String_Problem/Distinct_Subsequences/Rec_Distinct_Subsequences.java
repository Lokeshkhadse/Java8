package DP.DP_String_Problem.Distinct_Subsequences;

import java.util.ArrayList;
import java.util.List;

// question : - Given two strings s and t, return the number of distinct subsequences of s which equals t.
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
public class Rec_Distinct_Subsequences {
    public static void main(String[] args) {
        String s1 = "rabbbit";
        String t = "rabbit";

        int cnt = numDistinct(s1,t);
        System.out.println("Distinct_Subsequences is ->"+cnt);
    }
    public static int numDistinct(String s, String t) {

        List<String> list = new ArrayList<>();
        List<String> subsequnce = findSubsequence(0,s.toCharArray(),new StringBuilder(),list);

        long cnt = subsequnce.stream().filter(a -> a.equals(t)).count();

        return (int)cnt;

    }

    public static  List<String> findSubsequence(int index,char[] arr,StringBuilder current,List<String>list){
        if(index == arr.length){
            list.add(current.toString());
            return list;
        }

        //take
        current.append(arr[index]);
        findSubsequence(index+1,arr,current,list);

        //not take
        current.deleteCharAt(current.length()-1);
        findSubsequence(index+1,arr,current,list);

        return list;

    }

}
