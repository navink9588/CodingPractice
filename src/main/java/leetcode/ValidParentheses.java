package leetcode;

import java.util.Stack;

/**
 * @author Navin Kumar
 * @date 6/27/18
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 */
public class ValidParentheses {

    private boolean validParentheses(String string) {

        Stack<Character> openBrackets = new Stack<>();

        for(Character character : string.toCharArray()) {
            if(character == '(' || character == '{' || character == '[')
                openBrackets.push(character);
            else {
                Character lastOpenBracket = openBrackets.pop();
                if(character == ')' && lastOpenBracket != '(')
                    return false;
                else if(character == '}' && lastOpenBracket != '{')
                    return false;
                else if(character == ']' && lastOpenBracket != '[')
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String input = "()";
        boolean valid = validParentheses.validParentheses(input);
        System.out.printf("%s : %b\n", input, valid);

        input = "()[]{}";
        valid = validParentheses.validParentheses(input);
        System.out.printf("%s : %b\n", input, valid);

        input = "(]";
        valid = validParentheses.validParentheses(input);
        System.out.printf("%s : %b\n", input, valid);

        input = "([)]";
        valid = validParentheses.validParentheses(input);
        System.out.printf("%s : %b\n", input, valid);

        input = "{[]}";
        valid = validParentheses.validParentheses(input);
        System.out.printf("%s : %b\n", input, valid);
    }

}
