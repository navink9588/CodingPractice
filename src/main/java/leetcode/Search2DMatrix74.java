package leetcode;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class Search2DMatrix74 {

    private boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;

        if(matrix[0][0] > target || matrix[m-1][n-1] < target) return false;

        int i;
        for(i = 0; i < m; i++) {
            if(matrix[i][n-1] >= target)
                break;
        }

        if(matrix[i][n-1] == target) return true;

        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = (l+h)/2;
            if(matrix[i][mid] == target)
                return true;
            if(matrix[i][mid] < target)
                l = mid + 1;
            else
                h = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix74 search2DMatrix = new Search2DMatrix74();
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,50}
        };
        boolean found = search2DMatrix.searchMatrix(matrix, 3);
        System.out.println("Matrix contains 3: " + found);

        found = search2DMatrix.searchMatrix(matrix, 13);
        System.out.println("Matrix contains 13: " + found);
    }

}
