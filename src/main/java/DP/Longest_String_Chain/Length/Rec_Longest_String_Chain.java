package DP.Longest_String_Chain.Length;

import java.util.Arrays;
import java.util.Comparator;

public class Rec_Longest_String_Chain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int ans = longestStrChain(words);
        System.out.println("longest String chain length is -> " + ans);
    }
    public static int longestStrChain(String[] words) {
        int index = 0 ;
        int prevIndex = -1;
        String[] arr = Arrays.stream(words)
                .sorted(Comparator.comparingInt(s -> s.length()))
                .toArray(String[]::new);
        int ans = func(index,prevIndex,arr);
        return ans;

    }
    public static int func(int index,int prevIndex,String[] words){
        if(index == words.length){
            return 0;
        }

        //not take
        int nottake =0 + func(index+1,prevIndex,words);

        //take
        int take= Integer.MIN_VALUE;
        if(prevIndex == -1 || checkIsIncreasing(words[prevIndex],words[index])){
            take = 1 + func(index+1,index,words);
        }

        return Math.max(nottake,take);
    }

    public static boolean checkIsIncreasing(String a , String b){
        if(b.length() != a.length()+1) return false;

        int i = 0 ,j = 0;
        int skip = 0;

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else{
                skip++;
                j++;
                if(skip > 1) return false;
            }
        }
        return skip <= 1;
    }
}
