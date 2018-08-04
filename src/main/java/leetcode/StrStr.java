package leetcode;

/**
 * @author Navin Kumar
 * @date 6/30/18
 *
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class StrStr {

    private int strStr(String haystack, String needle) {
        int pos = -1;

        if(needle == null || needle.isEmpty()) return 0;
        if(haystack == null || haystack.isEmpty()) return pos;
        if (haystack.length() < needle.length()) return pos;

        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n; i++) {
            int j = 0;
            if(haystack.charAt(i) == needle.charAt(j)) {
                pos = i;
                i++; j++;
                while (j < m && i < n) {
                    if(haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        pos = -1;
                        break;
                    }
                }
                if(j != m)
                    pos = -1;
                else
                    return pos;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        StrStr strStr = new StrStr();
        System.out.println("Pos = " + strStr.strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "a";
        System.out.println("Pos = " + strStr.strStr(haystack, needle));
    }
}
