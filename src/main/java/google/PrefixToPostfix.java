package google;

import java.util.Stack;

/**
 * @author Navin Kumar
 * @date 7/14/18
 */
public class PrefixToPostfix {

    private boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    private String preToPost(String pre) {

        int n = pre.length();
        Stack<String> characters = new Stack<>();

        for(int i = n-1; i>=0; i--) {
            char ch = pre.charAt(i);
            if(isOperator(ch)) {
                String ch1 = characters.pop();
                String ch2 = characters.pop();
                characters.push(ch1 + ch2 + ch);
            } else {
                characters.push("" + ch);
            }
        }

        return characters.pop();
    }

    public static void main(String[] args) {
        PrefixToPostfix p2p = new PrefixToPostfix();
        String pre = "+*AB/CD";
        String post = p2p.preToPost(pre);
        System.out.printf("%s --> %s", pre, post);
    }

}
