package Stack_Queue.Previous_smallest_element;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class previous_smallest_ele {
    public static void main(String[] args) {
        int arr[] = {4,5,2,10,8};
        int n = arr.length;

        int newarr[] = new int[n];

        Stack<Integer>st = new Stack<>();

        for(int i = 0 ;i<n;i++){
            while(!st.isEmpty() && st.peek()>= arr[i]){
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
