package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 6/30/18
 */
public class GenerateParentheses {

    private List<String> generateParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        generateParentheses(parentheses, "", 0, 0 , n);
        return parentheses;
    }

    private void generateParentheses(List<String> parentheses, String cur, int open, int close, int n) {
        if(cur.length() == n * 2) {
            parentheses.add(cur);
            return;
        }

        if(open < close) return;

        if(open < n)
            generateParentheses(parentheses, cur+"(", open+1, close, n);
        if(close < n)
            generateParentheses(parentheses, cur+")", open, close+1, n);
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParentheses(3));
    }

}
