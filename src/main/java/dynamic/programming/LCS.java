package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/14/18
 * Longest Common Sub-Sequence
 */
public class LCS {

    // https://www.geeksforgeeks.org/longest-common-subsequence/
    // https://www.youtube.com/watch?v=HgUOWB0StNE&t=0s&index=7&list=PLqM7alHXFySGbXhWx7sBJEwY2DnhDjmxm
    int lcsLength(String a, String b) {
        if(a == null || a.isEmpty() || b == null || b.isEmpty())
            return 0;
        int m = a.length();
        int n = b.length();

        int[][] lcs = new int[m+1][n+1];
        for(int i = 0; i<=m; i++) {
            for(int j = 0; j<=n; j++) {
                if(i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        // Printing the LCS:
        // https://www.geeksforgeeks.org/printing-longest-common-subsequence/
        StringBuilder seq = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0)
        {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                seq.insert(0, a.charAt(i - 1));
                i--;
                j--;
            } else if (lcs[i-1][j] > lcs[i][j-1])
                i--;
            else
                j--;
        }

        System.out.println("LCS: " + seq.toString());


        return lcs[m][n];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int lcsLength = lcs.lcsLength(a, b);
        System.out.printf("LCS Length of %s, %s: %d\n", a, b, lcsLength);
    }

}
