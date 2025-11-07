package DP.DP_String_Problem.Substring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Print {
//    public static void main(String[] args) {
//        String s1 = "abcjklp";
//        String s2 = "acjkp";
//
//        String ans = function(s1,s2,"");
//        System.out.println("Longest_Common_Substring is --->" + ans);
//    }
//    public static String function(String s1,String s2,String ans){
//
//
//
//        for(int i = 0; i<s1.length(); i++){
//            for(int j = i+1;j<=s1.length();j++){
//                String sub  = s1.substring(i,j);
//
//                if(s2.contains(sub)){
//                    if (sub.length() > ans.length()) {
//                        ans = sub;
//                    }
//                }else{
//                    break;
//                }
//            }
//        }
//
//        return ans;
//
//    }


    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";
        List<String> list= new ArrayList<>();

        List<String> ans = function(s1,s2,list);
        String max = ans.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Longest_Common_Substring is --->" + max);
    }
    public static List<String> function(String s1,String s2,List<String> list){



        for(int i = 0; i<s1.length(); i++){
            for(int j = i+1;j<=s1.length();j++){
                String sub  = s1.substring(i,j);

                if(s2.contains(sub)){
                    list.add(sub);
                }else{
                    break;
                }
            }
        }

        return list;

    }
}


