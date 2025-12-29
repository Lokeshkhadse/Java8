package Stack_Queue.Sum_SubArray_Minimum;

import java.util.Stack;

public class Using_stack {
    static int mod = (int)1e9+7;
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        int n = arr.length;
        int ans = sumSubarrayMins(arr);
        System.out.println(ans);

    }
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] pse = new int[n]; // previous smaller
        int[] nse = new int[n]; // next smaller

        Stack<Integer> st = new Stack<>();

        // 1️⃣ Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // 2️⃣ Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // 3️⃣ Calculate answer
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum = (sum + arr[i] * left * right) % mod;
        }

        return (int) sum;
    }



}
