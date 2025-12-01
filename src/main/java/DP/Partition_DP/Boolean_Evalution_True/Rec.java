package DP.Partition_DP.Boolean_Evalution_True;

import java.util.ArrayList;
import java.util.List;

public class Rec {
    public static long MOD = 1000000007;
    public static void main(String[] args) {
        String exp = "F|T^F";
        int n = exp.length();
        List<Boolean> res = func(0,n-1,exp);

        int count = 0;
        for(boolean data:res){
            if(data){
                count++;
            }
        }
        int finalcnt = count % 1000000007;

        System.out.println(finalcnt);
    }

    public static List<Boolean> func(int i , int j , String exp){
        List<Boolean> res = new ArrayList<>();

        if(i == j){
            res.add(exp.charAt(i) == 'T');
            return res;
        }

        for(int k = i+1;k<=j-1;k = k+2){
            char op = exp.charAt(k);

            List<Boolean> left = func(i,k-1,exp);
            List<Boolean>right = func(k+1,j,exp);

            for(boolean l : left){
                for(boolean r : right){

                    if(op == '|'){
                        res.add(l || r);
                    }else if(op == '&'){
                        res.add(l && r);
                    }else{
                        res.add(l ^ r);
                    }
                }
            }
        }
        return res;
    }
}
