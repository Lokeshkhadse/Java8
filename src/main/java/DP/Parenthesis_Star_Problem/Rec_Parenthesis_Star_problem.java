package DP.Parenthesis_Star_Problem;

public class Rec_Parenthesis_Star_problem {
    public static void main(String[] args) {
        String s = "(*))";
        int index =0  ;
        int cnt = 0 ;
        boolean ans = isvalid(s,index,cnt);
        System.out.println(ans);
    }

    private static boolean isvalid(String s,int index , int cnt) {
        if(cnt < 0) return false;

        if(index == s.length()){
            return (cnt == 0);
        }

        char ch = s.charAt(index);
        if(ch == '('){
            return isvalid(s,index+1,cnt+1);
        }
        if(ch == ')'){
            return isvalid(s,index+1,cnt-1);
        }

        else{
            return
                            isvalid(s,index+1,cnt+1) ||   //(
                            isvalid(s,index+1,cnt-1)||    //)
                            isvalid(s,index+1,cnt);         //empty
        }
    }
}
