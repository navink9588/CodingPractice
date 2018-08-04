package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/15/18
 */
public class PartitionProblem {

    private boolean checkPartition(int[] a) {
        int n = a.length;

        int sum = 0;
        for(int an : a) sum += an;

        if(sum % 2 != 0) return false;
        sum = sum/2;

        return checkPartition(a, n, sum);
    }

    private boolean checkPartition(int[] a, int n, int sum) {
        if(sum == 0) return true;
        if(n == 0) return false;

        if(a[n-1] > sum) checkPartition(a, n-1, sum);

        return checkPartition(a, n-1, sum) ||
            checkPartition(a, n-1, sum - a[n-1]);
    }

    // Check SubsetSum for DP solution.

    public static void main(String[] args) {
        PartitionProblem pp = new PartitionProblem();
        int[] a = {3, 1, 5, 9, 12};
        boolean possible = pp.checkPartition(a);
        System.out.printf("Partition is %s possible\n", (possible ? "" : "not"));
        a = new int[]{3, 1, 1, 2, 2};
        possible = pp.checkPartition(a);
        System.out.printf("Partition is %s possible\n", (possible ? "" : "not"));
    }

}
