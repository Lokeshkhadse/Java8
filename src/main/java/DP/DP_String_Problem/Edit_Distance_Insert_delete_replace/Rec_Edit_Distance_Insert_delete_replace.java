package DP.DP_String_Problem.Edit_Distance_Insert_delete_replace;

public class Rec_Edit_Distance_Insert_delete_replace {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int m = s1.length();
        int n = s2.length();

        int ans = minOperations(s1,s2,m-1,n-1);
        System.out.println("Minimum step require to make s1 to s2 --> " + ans);
    }

    public static int minOperations(String s1,String s2,int i, int j){
        //base case
        if(i < 0) return j+1;  ////if s1 goes -1 then s1 remaining string  return
        if(j < 0)return i+1;  //if s2 goes -1 then s1 remaining string  return

        //match
        if(s1.charAt(i) == s2.charAt(j)){
            return 0 + minOperations(s1,s2,i-1,j-1);
        }

        //not match now perform insert, delete,replace operation

        //insert
        int insert = 1 + minOperations(s1,s2,i,j-1);

        //delete
        int delete = 1 + minOperations(s1,s2,i-1,j);

        //replace
        int replace = 1 +minOperations(s1,s2,i-1,j-1);

        return Math.min(insert,Math.min(delete,replace));
    }
}
