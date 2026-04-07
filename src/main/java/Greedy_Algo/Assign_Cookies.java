package Greedy_Algo;

import java.util.Arrays;

public class Assign_Cookies {
    public static void main(String[] args) {
        int parent[]= {1,5,3,3,4};
        int cookies[] = {4,2,1,2,1,3};
        int ans = findMaximumChildToGetCookies(parent,cookies);
        System.out.println("maximum parent to get cookies are ->" + ans);
    }
    public static int findMaximumChildToGetCookies(int[] parent, int[] cookies){
        Arrays.sort(parent);
        Arrays.sort(cookies);

        int m = parent.length;
        int n = cookies.length;

        int left = 0; //parent arr
        int right = 0; // cookies arr

        int track_How_many_parent_get_cookies = 0;

        while(left <m && right<n){
            if(parent[left] <= cookies[right]){
                track_How_many_parent_get_cookies++;
                left++;
                right++;
            }else{
                right++;
            }
        }
        return track_How_many_parent_get_cookies;
    }
}
