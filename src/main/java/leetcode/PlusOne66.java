package leetcode;

import java.util.Arrays;

/**
 * @author Navin Kumar
 * @date 7/25/18
 *
 * https://leetcode.com/problems/plus-one/description/
 * My own solution
 */
public class PlusOne66 {

    private int[] plusOne(int[] digits) {
        int n = digits.length;
        if (n == 0) return digits;

        int[] sum = new int[n+1];
        int carry = 0;

        int i = n - 1;
        sum[i + 1] = digits[i] + 1;
        if(sum[i + 1] == 10) {
            sum[i + 1] = 0;
            carry = 1;
        }

        for(i = n-2; i >= 0; i--) {
            sum[i+1] = digits[i] + carry;
            if(sum[i+1] == 10) {
                sum[i+1] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if(carry != 0) {
            sum[0] = carry;
            return sum;
        }

        return Arrays.copyOfRange(sum, 1, n + 1);
    }

    private void print(String what, int[] digits) {
        System.out.print(what + ": ");
        for(int d:digits) {
            System.out.print(d);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PlusOne66 plus = new PlusOne66();
        int[] digits = {9,9};
        int[] sum = plus.plusOne(digits);
        plus.print("Original", digits);
        plus.print("Sum", sum);
    }

}
