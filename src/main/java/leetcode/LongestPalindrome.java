package leetcode;

/**
 * @author Navin Kumar
 * @date 6/20/18
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {
    private String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //

    private String longestPalindromeDP(String str) {
        int n = str.length();
        boolean[][] table = new boolean[n][n];

        int max = 1;
        for(int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        int start = 0;
        for(int i = 0; i < n-1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                table[i][i+1] = true;
                start = i;
                max = 2;
            }
        }

        for(int k = 3; k <= n; k++) {
            for(int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;

                if(table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if(k > max) {
                        max = k;
                        start = i;
                    }
                }
            }
        }

        return str.substring(start, start + max);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindromeDP("babad"));
    }
}
