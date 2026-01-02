package Stack_Queue.Largest_Reactangle_In_Histogram;

import java.util.Stack;

public class Stack_Approach {
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println("largestRectangleArea is -> " + ans);
    }
    public static int largestRectangleArea(int[] heights){
        int n= heights.length;

        int nse[] = get_Next_Smaller_Element(heights);
        int pse[] = get_Previous_Smaller_Element(heights);

        int max = Integer.MIN_VALUE;

        for(int i = 0 ;i<n;i++){
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }
        return max;

    }

    public static int[] get_Next_Smaller_Element(int[] heights){
        int n = heights.length;;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i =n-1 ;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n:st.peek();

            st.push(i);
        }
        return nse;
    }

    public static int[] get_Previous_Smaller_Element(int[] heights){
        int n = heights.length;;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            pse[i] = st.isEmpty() ?-1:st.peek();

            st.push(i);
        }
        return pse;
    }

}
