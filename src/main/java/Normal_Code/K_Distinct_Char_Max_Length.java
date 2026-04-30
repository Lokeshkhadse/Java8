package Normal_Code;

import java.util.HashSet;
import java.util.Set;

public class K_Distinct_Char_Max_Length {
    public static void main(String[] args) {
        String  s = "abcdcsdsgugd";
        int k = 3;

        int ans = maxsub(s,k);
        System.out.println(ans);
    }
    public static int maxsub(String s, int k){
        if(s.length() < k){
            return 0;
        }
        int maxi  = 0;

        for(int i  = 0 ;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            for(int j = i;j<s.length();j++){
                set.add(s.charAt(j));
                if(set.size() > k){
                    break;
                }
                maxi = Math.max(maxi , j-i+1);
            }
        }
      return maxi;
    }
}
