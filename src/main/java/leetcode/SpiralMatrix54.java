package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/spiral-matrix/solution/
 *
 * Din't understand
 */
public class SpiralMatrix54 {

    // Solution - https://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
    private ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int x=0;
        int y=0;

        while(m>0 && n>0) {

            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //below, process a circle

            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }

            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }

            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }

            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n=n-2;
        }

        return result;
    }

    private List < Integer > spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        SpiralMatrix54 sm = new SpiralMatrix54();
        List<Integer> spiral = sm.spiralOrder2(m);
        System.out.println(spiral);
    }
}
