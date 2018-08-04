package amazon;

import java.util.Stack;

/**
 * @author Navin Kumar
 * @date 7/23/18
 */
public class StockSpan {

    // O(n^2)
    private int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] ss = new int[n];
        ss[0] = 1;

        for(int i = 1; i < n; i++) {
            ss[i] = 1;
            for(int j = i - 1; j >= 0 && prices[j] < prices[i]; j--) {
                ss[i]++;
            }
        }

        return ss;
    }

    // O(n)
    private int[] stockSpan2(int[] prices) {
        int n = prices.length;
        int[] ss = new int[n];
        ss[0] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] < prices[i])
                stack.pop();

            ss[i] = stack.isEmpty() ? (i+1) : (i - stack.peek());

            stack.push(i);
        }

        return ss;
    }

    public static void main(String[] args) {
        StockSpan ss = new StockSpan();
        int[] prices = {10, 4, 5, 90, 120, 80};
        int[] span = ss.stockSpan(prices);

        System.out.println("Span using method 1: ");
        for(int s : span)
            System.out.print(s + " ");
        System.out.println();

        int[] span2 = ss.stockSpan2(prices);

        System.out.println("Span using method 2: ");
        for(int s : span2)
            System.out.print(s + " ");
        System.out.println();
    }

}
