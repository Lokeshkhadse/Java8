package DP.DP_String_Problem.Wild_Card_Matching;

public class Rec_Wild_Card_Matching {
     //? -> single character match & * -> 0 to ..n length match in continuous sequence manner
    public static void main(String[] args) {
        String s = "abefgcd";
        String p = "ab*cd";

        int i = s.length();
        int j = p.length();

        boolean ans = func(s,p,i-1,j-1);
        System.out.println(ans);
    }
    public static boolean func(String s, String p , int i, int j){

        if(i < 0 && j < 0) return true;
        if(j < 0 && i >=0) return false;
        if(i < 0 && j >= 0){                   //// string empty but pattern remains
            for(int m = 0 ; m<=j;m++){
                if(p.charAt(m) != '*') return false;
            }
            return true;
        }

        // match  or pattern is ?
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return func(s,p,i-1,j-1);
        }

        // if pattern is * '*' can match empty or one/more characters
        if(p.charAt(j) == '*'){
            return func(s,p,i-1,j) || func(s,p,i,j-1);
        }

        //not match
        return false;
    }
}
