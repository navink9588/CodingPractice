package dynamic.programming;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 *
 * The isSubsetSum problem can be divided into two sub-problems
 * a) Include the last element, recur for n = n-1, sum = sum – set[n-1]
 * b) Exclude the last element, recur for n = n-1.
 * If any of the above the above sub problems return true, then return true.
 */
public class SubsetSum {

    // Returns true if there is a subset of set[] with sum equal to given sum
    private static boolean isSubsetSum(int[] in, int n, int sum) {
        // Base Cases
        if(sum == 0)
            return true;
        if(n == 0)
            return false;

        // If last element is greater than sum, then ignore it
        if(in[n-1] > sum)
            return isSubsetSum(in, n-1, sum);

        /*
            else, check if sum can be obtained by any of the following
            (a) including the last element
            (b) excluding the last element
        */
        return isSubsetSum(in, n-1, sum) ||
            isSubsetSum(in, n-1, sum - in[n-1]);
    }

    private static boolean isSubsetSumDP(int[] in, int sum) {
        int n = in.length;
        System.out.printf("Sum = %d, n = %d\n", sum, n);
        boolean[][] subset = new boolean[sum+1][n+1];
        for(int i = 0; i<= n; i++) {
            subset[0][i] = true;
        }

        for(int i = 1; i<=sum; i++) {
            for(int j = 1; j<=n; j++) {
                subset[i][j] = subset[i][j-1];
                if(i >= in[j-1]) {
                    subset[i][j] = subset[i][j] || subset[i - in[j-1]][j-1];
                }
            }
        }

        print(subset);

        return subset[sum][n];
    }

    private static void print(boolean[][] subset) {
        for(boolean[] i : subset) {
            System.out.print("[ ");
            for (boolean j : i) {
                System.out.print(j + " ");
            }
            System.out.println("]");
        }
        System.out.println("-----");
    }

    public static void main (String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");

        sum = 6;
        if (isSubsetSumDP(set, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

}
