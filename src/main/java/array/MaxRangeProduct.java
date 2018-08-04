package array;

import sun.jvm.hotspot.utilities.Assert;

/**
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * For a given array of integers, compute the maximum sum of any
 * range in the array. Then modify the function to find the maximum
 * product. Note the effect of -ves on the max product
 */
public class MaxRangeProduct {

    private static int maxSubarrayProduct(int arr[]) {
        int maxTillHere = 1;
        int minTillHere = 1;

        int maxEver = 1;

        for(int v : arr) {
            if(v == 0) {
                maxTillHere = 1;
                minTillHere = 1;
            } else if(v > 0) {
                maxTillHere *= v;
                minTillHere = Math.min(1, minTillHere * v);
            } else {
                int temp = maxTillHere;
                maxTillHere = Math.max(1, minTillHere * v);
                minTillHere = temp * v;
            }

            maxEver = Math.max(maxTillHere, maxEver);
        }

        return maxEver;
    }

    public static void main(String[] args) {
        int[] in = {-2, -3, 4, 0, -1, -2, 1, 5, -3};

        Assert.that(maxSubarrayProduct(in) == 30, "incorrect max product");
    }
}
