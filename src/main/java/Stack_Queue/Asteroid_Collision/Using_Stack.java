package Stack_Queue.Asteroid_Collision;

import java.util.Arrays;
import java.util.Stack;

public class Using_Stack {
    public static void main(String[] args) {
        int arr[] = {3,5,-6,2,-1,4};
        int[] finalans  = asteroidCollision(arr);
        System.out.println("Remaining array after AsteroidCollision is -> " + Arrays.toString(finalans));
    }
    public static int[] asteroidCollision(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i= 0;i<n;i++){
            int curr = arr[i];
            int abs = Math.abs(arr[i]);

            if(curr > 0){
                st.push(curr);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && abs > st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && abs == st.peek()){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(curr);

                }
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}
