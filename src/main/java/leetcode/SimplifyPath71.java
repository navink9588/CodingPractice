package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath71 {


    // solution - https://www.programcreek.com/2014/04/leetcode-simplify-path-java/
    private String simplifyPath(String path) {
        int n = path.length();
        while(n > 0 && path.charAt(n - 1) == '/') {
            path = path.substring(0, n - 1);
            n = path.length();
        }

        if(n == 0) return "/";

        Stack<String> stack = new Stack<>();
        int start = 0;
        for(int i = 1; i < n; i++){
            if(path.charAt(i) == '/'){
                stack.push(path.substring(start, i));
                start = i;
            } else if(i == n - 1) {
                stack.push(path.substring(start));
            }
        }

        LinkedList<String> result = new LinkedList<>();
        int back = 0;
        while(!stack.isEmpty()){
            String top = stack.pop();
            if(top.equals("/.") || top.equals("/")) {
                //nothing
            } else if(top.equals("/..")) {
                back++;
            } else {
                if(back > 0) {
                    back--;
                } else {
                    result.addFirst(top);
                }
            }
        }

        //if empty, return "/"
        if(result.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) {
            String s = result.pollFirst();
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath71 simplifyPath = new SimplifyPath71();
        String original = "/home/";
        String simplified = simplifyPath.simplifyPath(original);
        System.out.printf("%s --> %s\n", original, simplified);

        original = "/a/./b/../../c/";
        simplified = simplifyPath.simplifyPath(original);
        System.out.printf("%s --> %s\n", original, simplified);

        original = "/a/./b/..//c/";
        simplified = simplifyPath.simplifyPath(original);
        System.out.printf("%s --> %s\n", original, simplified);

        original = "/../";
        simplified = simplifyPath.simplifyPath(original);
        System.out.printf("%s --> %s\n", original, simplified);

        original = "/";
        simplified = simplifyPath.simplifyPath(original);
        System.out.printf("%s --> %s\n", original, simplified);

        original = "/home//foo/";
        simplified = simplifyPath.simplifyPath(original);
        System.out.printf("%s --> %s\n", original, simplified);
    }

}
