package Stack_Queue.Online_Stock_Span;

import java.util.Stack;

public class Using_Stack_but_normal {

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] spans = stockSpan(prices);

        for (int span : spans) {
            System.out.print(span + " ");
        }
    }

    public static int[] stockSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {

            Stack<Integer> st = new Stack<>();
            int count = 0;

            // check backward
            for (int j = i; j >= 0; j--) {
                if (prices[j] <= prices[i]) {
                    count++;
                } else {
                    break;
                }
            }

            span[i] = count;
        }

        return span;
    }
}
