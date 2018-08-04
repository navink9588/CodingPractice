package array;

import sun.jvm.hotspot.utilities.Assert;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * LinkedIn Problem
 * https://www.careercup.com/page?pid=linkedin-interview-questions
 *
 * For a given array of integers, compute the maximum sum of any
 * range in the array. Then modify the function to find the maximum
 * product. Note the effect of -ves on the max product
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaxRangeSum {

    private static int maxSum(int[] in) {
        int maxSum = 0;
        int curSum = 0;

        for (int anIn : in) {
            curSum += anIn;

            if (curSum < 0)
                curSum = 0;
            else if (curSum > maxSum)
                maxSum = curSum;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] in = {-2,1,-3,4,-1,2,1,-5,4};

        Assert.that(maxSum(in) == 6, "incorrect max sum");
    }
}
