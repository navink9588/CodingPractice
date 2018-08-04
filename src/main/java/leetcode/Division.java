package leetcode;

/**
 * @author Navin Kumar
 * @date 7/6/18
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 */
public class Division {

    private int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 0) throw new  RuntimeException("Illegal divisor");

        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return neg ? -quotient : quotient;
    }

    public static void main(String[] args) {
        Division division = new Division();
        int dividend = 10;
        int divisor = 3;
        int quotient = division.divide(dividend, divisor);
        System.out.printf("%d/%d = %d\n", dividend, divisor, quotient);

        dividend = 7;
        divisor = -3;
        quotient = division.divide(dividend, divisor);
        System.out.printf("%d/%d = %d\n", dividend, divisor, quotient);

        dividend = 0;
        quotient = division.divide(dividend, divisor);
        System.out.printf("%d/%d = %d\n", dividend, divisor, quotient);

        dividend = 7;
        divisor = 0;
        quotient = division.divide(dividend, divisor);
        System.out.printf("%d/%d = %d\n", dividend, divisor, quotient);
    }

}
