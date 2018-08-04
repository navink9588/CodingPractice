package linkedin;

import java.util.LinkedList;

/**
 * @author Navin Kumar
 * @date 7/5/18
 *
 * https://www.careercup.com/question?id=5163286157852672
 *
 * My own solution. Yay!!!
 */
public class PrintMatrixDiagonally {

    private static class Pair {
        int m;
        int n;
        Pair(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }

    private void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        LinkedList<Pair> queue = new LinkedList<>();
        queue.addFirst(new Pair(m-1, 0));
        visited[m-1][0] = true;
        int size = 1;

        while (size != 0) {
            Pair pair = queue.removeFirst();
            size--;
            System.out.print(matrix[pair.m][pair.n] + " ");
            // North
            if(pair.m - 1 >= 0 && !visited[pair.m-1][pair.n]) {
                queue.addLast(new Pair(pair.m-1, pair.n));
                visited[pair.m-1][pair.n] = true;
            }
            // West
            if(pair.n + 1 < n && !visited[pair.m][pair.n + 1]) {
                queue.addLast(new Pair(pair.m, pair.n+1));
                visited[pair.m][pair.n + 1] = true;
            }
            // South
            if(pair.m + 1 < m && !visited[pair.m + 1][pair.n]) {
                queue.addLast(new Pair(pair.m + 1, pair.n));
                visited[pair.m + 1][pair.n] = true;
            }
            // East
            if(pair.n - 1 >= 0 && !visited[pair.m][pair.n - 1]) {
                queue.addLast(new Pair(pair.m, pair.n - 1));
                visited[pair.m][pair.n - 1] = true;
            }

            if(size == 0) {
                System.out.println();
                size = queue.size();
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6 ,7 ,8},
            {9, 10, 11, 12}
        };

        PrintMatrixDiagonally diag = new PrintMatrixDiagonally();
        diag.printMatrix(matrix);
    }

}
