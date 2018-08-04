package leetcode;

import java.util.Arrays;

/**
 * @author Navin Kumar
 * @date 7/7/18
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {

    // My solution starts here
    private int missing(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int i = 0;
        while (i < n) {
            if(a[i] <= 0) i++;
            else break;
        }

        if (i == n) return 1;

        for(int j = i; j < n; j++) {
            if(a[j] != j - i + 1)
                return j - i + 1;
        }

        return n;
    }
    // My solution ends here

    // https://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
    private int missing2(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // when the ith element is not i
            while (A[i] != i) {
                // no need to swap when ith element is out of range [0,n]
                if (A[i] < 0 || A[i] >= n)
                    break;

                //handle duplicate elements
                if(A[i]==A[A[i]])
                    break;
                // swap elements
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i)
                return i;
        }

        return n;
    }

    public static void main(String[] args) {
        FirstMissingPositive m = new FirstMissingPositive();
        int[] a = {1,2,0};
        System.out.println(m.missing(a));

        int[] a1 = {3,4,-1,1};
        System.out.println(m.missing2(a1));

        int[] a2 = {7,8,9,11,12};
        System.out.println(m.missing(a2));

    }

}
