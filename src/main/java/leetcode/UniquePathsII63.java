package leetcode;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * Based on idea from UniquePaths62
 * Solution - https://www.programcreek.com/2014/05/leetcode-unique-paths-ii-java/
 */
public class UniquePathsII63 {

    private int uniquePathsDP(int[][] obstacleGrid) {

        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0]=1;

        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] != 1)
                dp[i][0] = dp[i-1][0];
            else
                dp[i][0] = 0;
        }

        for(int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] != 1)
                dp[0][i] = dp[0][i-1];
            else
                dp[0][i] = 0;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else
                    dp[i][j] = 0;
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePathsII63 up = new UniquePathsII63();
        int[][] obstacleGrid = {
            {0,1,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };

        int path = up.uniquePathsDP(obstacleGrid);
        System.out.println(path);
    }

}
