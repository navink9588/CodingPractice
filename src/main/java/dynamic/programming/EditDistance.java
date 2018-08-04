package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/14/18
 *
 * VVI
 */
public class EditDistance {

    // https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
    private int distance(String a, String b) {
        if(a == null || a.isEmpty() || b == null || b.isEmpty())
            return 0;
        int m = a.length();
        int n = b.length();

        int[][] ops = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0)
                    ops[i][j] = j;
                else if(j == 0)
                    ops[i][j] = i;
                else if(a.charAt(i-1) == b.charAt(j-1))
                    ops[i][j] = ops[i-1][j-1];
                else
                    ops[i][j] = 1 + Math.min(ops[i][j-1], Math.min(ops[i-1][j], ops[i-1][j-1]));
            }
        }
        return ops[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String a = "sunday";
        String b = "saturday";
        int ops = editDistance.distance(a, b);
        System.out.printf("Ops from %s to %s: %d\n", a, b, ops);
    }

}
