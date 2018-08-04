package leetcode;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * Solution - https://www.programcreek.com/2014/05/leetcode-unique-paths-java/
 */
public class UniquePaths62 {

    private int uniquePaths(int m, int n) {
        return uniquePaths(0, 0,m, n);
    }

    private int uniquePaths(int i, int j, int m, int n) {
        if(i == m - 1 && j == n - 1) {
            return 1;
        }

        if(i < m-1 && j < n-1) {
            return uniquePaths(i+1,j,m,n) + uniquePaths(i,j+1,m,n);
        }

        if(i < m-1) {
            return uniquePaths(i+1,j,m,n);
        }

        if(j < n-1) {
            return uniquePaths(i,j+1,m,n);
        }

        return 0;
    }

    private int uniquePathsDP(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;

        int[][] dp = new int[m][n];

        //left column
        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }

        //top row
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        //fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths62 up = new UniquePaths62();
        int m = 3, n = 2;
        int paths = up.uniquePaths(m, n);
        System.out.println(paths);

        m = 7; n = 3;
        paths = up.uniquePathsDP(m, n);
        System.out.println(paths);
    }

}
