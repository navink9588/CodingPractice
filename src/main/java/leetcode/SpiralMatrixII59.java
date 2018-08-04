package leetcode;

/**
 * @author Navin Kumar
 * @date 7/22/18
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 */
public class SpiralMatrixII59 {

    // Solution based on SpiralMatrix54
    private int[][] generateMatrix(int n) {

        int start = 1;

        int x = 0, y = 0;
        int m = n;

        int[][] matrix = new int[n][n];

        while (m > 0 && n > 0) {

            if(m==1){
                for(int i=0; i<n; i++){
                    matrix[x][y++] = start++;
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    matrix[x++][y] = start++;
                }
                break;
            }

            //top - move right
            for(int i=0;i<n-1;i++){
                matrix[x][y++] = start++;
            }

            //right - move down
            for(int i=0;i<m-1;i++){
                matrix[x++][y] = start++;
            }

            //bottom - move left
            for(int i=0;i<n-1;i++){
                matrix[x][y--] = start++;
            }

            //left - move up
            for(int i=0;i<m-1;i++){
                matrix[x--][y] = start++;
            }

            x++;
            y++;
            m=m-2;
            n=n-2;
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII59 sm = new SpiralMatrixII59();
        int n = 4;
        int[][] m = sm.generateMatrix(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
