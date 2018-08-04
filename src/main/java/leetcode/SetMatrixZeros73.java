package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeros73 {

    // My solution
    private void setZeros(int[][] matrix) {
        print("1) Original", matrix);
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer[]> coods = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    coods.add(new Integer[]{i, j});
                }
            }
        }

        for(Integer[] cood : coods) {
            int i = cood[0];
            int j = cood[1];

            for(int k = 0; k < m; k++) {
                matrix[k][j] = 0;
            }
            for(int k = 0; k < n; k++) {
                matrix[i][k] = 0;
            }
        }

        print("1) Updated", matrix);
    }

    // https://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/
    private void setZeros2(int[][] matrix) {
        print("2) Original", matrix);
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        //set first row and column zero or not
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        //mark zeros on first row and column
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use mark to set elements
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        print("2) Updated", matrix);
    }

    private void print(String what, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(what + ":");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SetMatrixZeros73 setMatrixZeros = new SetMatrixZeros73();
        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setMatrixZeros.setZeros(matrix);

        matrix = new int[][]{
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        setMatrixZeros.setZeros(matrix);

        int[][] matrix1 = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setMatrixZeros.setZeros2(matrix1);

        matrix1 = new int[][]{
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        setMatrixZeros.setZeros2(matrix1);
    }

}
