package Normal_Code;

import java.util.HashSet;
import java.util.Set;

public class longestUniqueSubstr {
    public static void main(String[] args) {
        String  s = "geeksforgeeks";

        int ans = longestUniqueSubstr(s);
        System.out.println(ans);
    }
    public static int longestUniqueSubstr(String s) {


        int maxi  = 0;

        for(int i  = 0 ;i<s.length();i++){

            Set<Character> set = new HashSet<>();

            for(int j = i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }

                set.add(s.charAt(j));

                maxi = Math.max(maxi , j-i+1);
            }
        }
        return maxi;
    }
}
