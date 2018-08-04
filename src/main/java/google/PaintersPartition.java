package google;

/**
 * @author Navin Kumar
 * @date 6/25/18
 *
 * Google Problem
 * https://practice.geeksforgeeks.org/problems/the-painters-partition-problem/0
 *
 * Solution
 * https://articles.leetcode.com/the-painters-partition-problem-part-ii/
 *
 */
public class PaintersPartition {

    private int getRequiredPainters(int A[], int maxLengthPerPainter) {
        int total = 0, numPainters = 1;
        for (int a : A) {
            total += a;
            if (total > maxLengthPerPainter) {
                total = a;
                numPainters++;
            }
        }
        return numPainters;
    }

    private int partition(int A[], int k) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for (int aA : A) {
            if (aA > lo)
                lo = aA;
            hi += aA;
        }

        while (lo < hi) {
            int mid = (hi+lo)/2;
            int requiredPainters = getRequiredPainters(A, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }

    public static void main(String[] args) {
        PaintersPartition paintersPartition = new PaintersPartition();
        int A[] = {10, 10, 10, 10};
        System.out.println(paintersPartition.partition(A, 2));
        A = new int[] {10, 20, 30, 40};
        System.out.println(paintersPartition.partition(A, 2));
    }

}
