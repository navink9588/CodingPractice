package leetcode;

import java.util.Stack;

/**
 * @author Navin Kumar
 * @date 7/6/18
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * Imp
 */
public class LongestValidParentheses {

    private int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }

        return maxans;
    }

    // Dynamic programming approach. Not 100% correct
    private String longestParentheses(String s) {
        int max = 0;
        int start = 0;
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        for(int i = 0 ; i < n - 1; i++) {
            if(s.charAt(i) == '(' && s.charAt(i+1) == ')') {
                table[i][i+1] = true;
                max = 2;
                start = i;
            }
        }

        for(int k = 3; k <= n; k++) {
            for(int i = 0; i < n - k + 1; i++) {
                int j = i + k -1;
                if(table[i+1][j-1] && s.charAt(i) == '(' && s.charAt(j) == ')') {
                    table[i][j] = true;
                    if(k > max) {
                        max = k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        LongestValidParentheses p = new LongestValidParentheses();
        String s = "(()";
        int longest = p.longestValidParentheses(s);
        System.out.printf("%s = %d\n", s, longest);
        String parentheses = p.longestParentheses(s);
        System.out.printf("DP: %s = %s, size = %d\n", s, parentheses, parentheses.length());

        s = ")()())";
        longest = p.longestValidParentheses(s);
        System.out.printf("%s = %d\n", s, longest);
        parentheses = p.longestParentheses(s);
        System.out.printf("DP: %s = %s, size = %d\n", s, parentheses, parentheses.length());

        s = "()(()"; // Right answer is 2 i.e., the first ()
        longest = p.longestValidParentheses(s);
        System.out.printf("%s = %d\n", s, longest);
        parentheses = p.longestParentheses(s);
        System.out.printf("DP: %s = %s, size = %d\n", s, parentheses, parentheses.length());
    }
}
