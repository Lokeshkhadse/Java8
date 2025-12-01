package DP.Palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning_II {
    public static void main(String[] args) {
        String s = "abaa";
        List<List<String>> finalans = partition(s);

        int min = Integer.MAX_VALUE;

        for (List<String> lst : finalans) {
            min = Math.min(min, lst.size());
        }

        System.out.println("Minimum Cuts: " + (min - 1));
        System.out.println(min);
        System.out.println(finalans);
    }

    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
         function(0,s,ans,list);
        return ans;
    }

    public static void function(int index , String s, List<List<String>> ans,List<String> list){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index;i < s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){
                list.add(sub);
                function(i+1,s,ans,list);

                list.remove(list.size()-1);
            }
        }
    }

  public static boolean isPalindrome(String sub){
        boolean res = false;

        res = new StringBuilder(sub).reverse().toString().equals(sub);

        return res;
  }
}
