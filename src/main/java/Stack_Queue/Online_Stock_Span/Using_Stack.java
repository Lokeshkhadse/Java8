package Stack_Queue.Online_Stock_Span;

import java.util.Stack;

public class Using_Stack {

    // StockSpanner inner class
    static class StockSpanner {

        // Stack stores: {price, span}
        Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {

            int span = 1;

            // Pop all prices <= current price
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});
            return span;
        }
    }

    // psvm
    public static void main(String[] args) {

        StockSpanner sp = new StockSpanner();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        for (int price : prices) {
            System.out.print(sp.next(price) + " ");
        }
    }
}
