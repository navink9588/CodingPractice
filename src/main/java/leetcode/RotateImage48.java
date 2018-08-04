package leetcode;

/**
 * @author Navin Kumar
 * @date 7/21/18
 *
 * https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage48 {

    // Solution - https://www.programcreek.com/2013/01/leetcode-rotate-image-java/
    private void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    private void print(int[][] m) {
        int n = m.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage48 r = new RotateImage48();
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original: ");
        r.print(m);
        r.rotate(m);
        System.out.println("Rotated: ");
        r.print(m);
    }
}
