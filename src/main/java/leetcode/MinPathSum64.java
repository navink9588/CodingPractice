package leetcode;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * My own solution
 */
public class MinPathSum64 {

    private String minPath;
    private int minPathSum;
    private String minPath(int[][] a) {
        minPathSum = Integer.MAX_VALUE;
        minPath(a, 0, 0, String.valueOf(a[0][0]), a[0][0]);
        System.out.println("MinPathSum: " + minPathSum);
        return minPath;
    }

    private void minPath(int[][] a, int i, int j, String path, int pathSum) {
        if(i == a.length - 1 && j == a[0].length - 1) {
            if(minPathSum > pathSum) {
                minPath = path;
                minPathSum = pathSum;
            }
            return;
        }

        if(i < a.length - 1  && j < a[0].length - 1) {
            minPath(a, i + 1, j, path + "->" + a[i+1][j], pathSum + a[i+1][j]);
            minPath(a, i, j + 1, path + "->" + a[i][j+1], pathSum + a[i][j+1]);
        }

        if(j < a[0].length - 1) {
            minPath(a, i, j + 1, path + "->" + a[i][j+1], pathSum + a[i][j+1]);
        }

        if(i < a.length - 1) {
            minPath(a, i + 1, j, path + "->" + a[i+1][j], pathSum + a[i+1][j]);
        }
    }

    public static void main(String[] args) {
        MinPathSum64 minSum = new MinPathSum64();
        int[][] a = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };

        String minPath = minSum.minPath(a);
        System.out.println(minPath);
    }

}
