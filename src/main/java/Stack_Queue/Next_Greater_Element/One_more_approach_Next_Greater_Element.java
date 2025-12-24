package Stack_Queue.Next_Greater_Element;

import java.util.Arrays;
import java.util.Stack;

public class One_more_approach_Next_Greater_Element {
    public static void main(String[] args) {
        int arr[] = {6,0,8,9,1,3};
        int n  = arr.length;

        int newArr[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                newArr[i] = -1;
            }else{
                newArr[i] = st.peek();
            }

            st.push(arr[i]);
        }

        System.out.println(Arrays.toString(newArr));
    }
}
