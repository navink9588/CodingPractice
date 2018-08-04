package leetcode;

/**
 * @author Navin Kumar
 * @date 6/21/18
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {

    private String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < n; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strings));
    }
}
