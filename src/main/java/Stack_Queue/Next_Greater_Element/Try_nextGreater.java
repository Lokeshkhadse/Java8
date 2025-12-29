package Stack_Queue.Next_Greater_Element;

import java.util.Arrays;
import java.util.Stack;

public class Try_nextGreater {
    public static void main(String[] args) {
        int arr[] = {6,0,8,9,1,3};
        int n = arr.length;

        int newarr[] = new int[n];

        Stack<Integer>st = new Stack<>();

        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                newarr[i] = -1;
            }else{
                newarr[i] = st.peek();
            }
            st.push(arr[i]);
        }

        System.out.println(Arrays.toString(newarr));
    }
}
