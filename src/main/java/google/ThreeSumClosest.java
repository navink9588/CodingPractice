package google;

import java.util.Arrays;

/**
 * @author Navin Kumar
 * @date 6/25/18
 *
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {

    private int[] bruteForce(int[] a, int target) {
        int[] values = new int[3];
        int diff = Integer.MAX_VALUE;
        int n = a.length;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++)
                for(int k = j + 1; k < n; k++) {
                    int sum = a[i] + a[j] + a[k];
                    int curDiff = Math.abs(sum - target);
                    if(curDiff < diff) {
                        diff = curDiff;
                        values[0] = a[i];
                        values[1] = a[j];
                        values[2] = a[k];
                    }
                }
        }

        return values;
    }

    private int[] sorted(int[] a, int target) {
        int[] values = new int[3];
        Arrays.sort(a);

//        print(a);

        int closestDiff = Integer.MAX_VALUE;

        int n = a.length;
        for(int i = 0; i < n - 1; i++) {
            if(i != 0 && a[i] == a[i-1])
                continue;
            int l = i + 1;
            int r = n - 1;
            int curr = a[i];

            while (l < r) {
                int sum = a[l] + a[r] + curr;
                int currDiff = Math.abs(sum - target);
                if(currDiff < closestDiff) {
                    closestDiff = currDiff;
                    values[0] = curr;
                    values[1] = a[l];
                    values[2] = a[r];
                    r--;
                } else if(currDiff > closestDiff) l++;
            }
        }

        return values;
    }

    private void print(int[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for(int v : a) {
            builder.append(v).append(" ");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();
        int[] a = {-2, 2, 1, -4};
        int[] values = closest.bruteForce(a, 1);
        closest.print(values);
        System.out.println("----");
        values = closest.sorted(a, 1);
        closest.print(values);
    }

}
