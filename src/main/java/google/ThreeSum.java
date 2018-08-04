package google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Navin Kumar
 * @date 6/25/18
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 *
 */
public class ThreeSum {

    private void sum(int[] arr) {
        Arrays.sort(arr);

        Set<Integer> unique = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            if(unique.contains(arr[l]) || unique.contains(arr[r]) || unique.contains(x)) {
                continue;
            }
            while (l < r)
            {
                if (x + arr[l] + arr[r] == 0) {
                    unique.add(arr[l]);
                    unique.add(arr[r]);
                    unique.add(x);
                    // print elements if it's sum is zero
                    System.out.printf("%d %d %d\n", x, arr[l], arr[r]);
                    l++;
                    r--;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;
                // if sum is greater than zero than
                // decrement in right side
                else
                    r--;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] a = {-1, 0, 1, 2, -1, -4};
        threeSum.sum(a);
    }

}
