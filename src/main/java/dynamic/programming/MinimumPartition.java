package dynamic.programming;

/**
 * @author Navin Kumar
 * @date 7/15/18
 */
public class MinimumPartition {

    private int minPartition(int[] a) {
        int n = a.length;
        int sum = 0;
        for(int an : a) sum += an;
        return minPartition(a, n, 0, sum);
    }

    private int minPartition(int[] a, int n, int curSum, int totalSum) {
        if(n == 0)
            return Math.abs(curSum - (totalSum - curSum));

        return Math.min(minPartition(a, n-1, curSum + a[n-1], totalSum),
            minPartition(a, n-1, curSum, totalSum));
    }

    public static void main(String[] args) {
        MinimumPartition mp = new MinimumPartition();
        int[] a = {3, 1, 4, 2, 2, 1};
        int min = mp.minPartition(a);
        System.out.println("Min partition diff: " + min);
    }

}
