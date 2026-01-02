package Stack_Queue.Remove_K_Digit_FindSmallest_Number;

import java.util.Stack;

public class Using_Stack {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        String finalans = removeKdigits(num,k);
        System.out.println(finalans);
    }
    public static String removeKdigits(String num, int k) {

        Stack<Character>st = new Stack<>();

        for(char ch : num.toCharArray()){

            while(!st.isEmpty() && k > 0 && st.peek() > ch){  // here we are removing greater character form stack with current ch
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k>0 &&!st.isEmpty()){  //if string completed and still k is remaining then last character we are removing
            st.pop();
            k--;
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        // Remove leading zeros
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;

        String res = (i == sb.length()) ? "0" : sb.substring(i);   //example - 00123 -> 123
        return res;
    }
}
