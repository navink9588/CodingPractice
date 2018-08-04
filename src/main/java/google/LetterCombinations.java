package google;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 6/25/18
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * https://soulmachine.gitbooks.io/algorithm-essentials/java/brute-force/letter-combinations-of-a-phone-number.html
 */
public class LetterCombinations {

    private static final String[] keyboard =
        new String[]{ "", "", "abc", "def", // '0','1','2',...
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        dfs(digits, 0, "", result);
        return result;
    }

    private static void dfs(String digits, int cur, String path, List<String> result) {
        if (cur == digits.length()) {
            result.add(path);
            return;
        }

        for (char c : keyboard[Character.getNumericValue(digits.charAt(cur))].toCharArray()) {
            dfs(digits, cur + 1, path + c, result);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }

}
